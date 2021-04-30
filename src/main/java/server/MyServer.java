package server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.MessageModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class MyServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException, SQLException {
//        URL home = new URL("http://127.0.0.1:7777/");

        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String greeting = in.readLine();
        out.println(readMessage(greeting));
//        if ("hello server".equals(greeting)) {
//            out.println("hello client!");
//        }
//        else {
//            out.println("unrecognised greeting");
//        }
    }
    private String readMessage(String msg) throws JsonProcessingException, HibernateException {
        ObjectMapper objectMapper = new ObjectMapper();
        MessageModel messageModel = objectMapper.readValue(msg, MessageModel.class);
        System.out.println("message to " + messageModel.getClient());
        StringWriteToDB(messageModel);
        return messageModel.toString();
    }

    private void StringWriteToDB(MessageModel messageModel){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<MessageModel> criteriaQuery = cb.createQuery(MessageModel.class);
        Root<MessageModel> root = criteriaQuery.from(MessageModel.class);
        Transaction tx = session.beginTransaction();
        session.save(messageModel);
        tx.commit();
        session.close();

    }

    public void stop() throws IOException{
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public void startConnection(String ip, int port) throws IOException{
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException{
        out.println(msg);
        System.out.println();
        return in.readLine();
    }

    public String echoMessage(String msg) throws IOException{
        if (".".equals(msg)) {
                out.println("good bye");
                return in.readLine();
            }
            out.println(msg);

        return in.readLine();
    }

    public void stopConnection() throws IOException{
        in.close();
        out.close();
        clientSocket.close();
    }
    public static void main(String[] args) throws IOException, SQLException {
        MyServer server=new MyServer();
        server.start(7777);
    }
}
