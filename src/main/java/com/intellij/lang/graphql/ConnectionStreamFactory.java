package com.intellij.lang.graphql;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.nio.channels.Channels;


/**
 * A factory for creating the streams for supported
 * transmission methods.
 *
 * @author Gorkem Ercan
 *
 */
public class ConnectionStreamFactory {


  private interface StreamProvider{
    InputStream getInputStream() throws IOException;
    OutputStream getOutputStream() throws IOException;
  }


  private final class SocketStreamProvider implements StreamProvider{
    private final String readHost;
    private final String writeHost;
    private final int readPort;
    private final int writePort;


    public SocketStreamProvider(String readHost, int readPort, String writeHost, int writePort) {
      this.readHost = readHost;
      this.readPort = readPort;
      this.writeHost = writeHost;
      this.writePort = writePort;
    }

    @Override
    public InputStream getInputStream() throws IOException{
      Socket readSocket = new Socket(readHost,readPort);
      return readSocket.getInputStream();
    }

    @Override
    public OutputStream getOutputStream() throws IOException{
      Socket writeSocket = new Socket(writeHost, writePort);
      return writeSocket.getOutputStream();
    }

  }

  private final class StdIOStreamProvider implements StreamProvider{

    /* (non-Javadoc)
     * @see org.eclipse.jdt.ls.core.internal.ConnectionStreamFactory.StreamProvider#getInputStream()
     */
    @Override
    public InputStream getInputStream() throws IOException {
      return System.in;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jdt.ls.core.internal.ConnectionStreamFactory.StreamProvider#getOutputStream()
     */
    @Override
    public OutputStream getOutputStream() throws IOException {
      return System.out;
    }

  }

  private static String OS = System.getProperty("os.name").toLowerCase();
  private StreamProvider provider;
  private static ConnectionStreamFactory instance;

  private StreamProvider getSelectedStream(){
    if (provider == null) {
      final String stdInName = System.getenv("STDIN_PIPE_NAME");
      final String stdOutName = System.getenv("STDOUT_PIPE_NAME");
      if (stdInName != null && stdOutName != null) {
        System.out.println("should be namedpipestream");
//        provider= new NamedPipeStreamProvider(stdOutName, stdInName);
      }
      final String wHost = System.getenv().getOrDefault("STDIN_HOST", "localhost");
      final String rHost = System.getenv().getOrDefault("STDOUT_HOST", "localhost");
      final String wPort = System.getenv().get("STDIN_PORT");
      final String rPort = System.getenv().get("STDOUT_PORT");
      if (rPort != null && wPort != null) {
        provider = new SocketStreamProvider(rHost, Integer.parseInt(rPort), wHost, Integer.parseInt(wPort));
      }
      if(provider == null ){//Fall back to std io
        provider = new StdIOStreamProvider();
      }
    }
    return provider;
  }

  private static ConnectionStreamFactory getInstance(){
    if(instance == null){
      instance= new ConnectionStreamFactory();
    }
    return instance;
  }

  public static InputStream getInputStream() throws IOException{
    return getInstance().getSelectedStream().getInputStream();
  }

  public static OutputStream getOutputStream() throws IOException{
    return getInstance().getSelectedStream().getOutputStream();
  }

}