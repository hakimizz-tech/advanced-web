package com.example;

import jakarta.annotation.Resource;
import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSProducer;
import jakarta.jms.Queue;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sendMessage")
public class MessageProducerServlet extends HttpServlet {

    @Resource(lookup = "jms/MyConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/MyQueue")
    private Queue queue;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String messageText = req.getParameter("message");
        if (messageText == null) {
            messageText = "Hello, from WhisperStream!";
        }

        try (JMSContext context = connectionFactory.createContext()) {
            JMSProducer producer = context.createProducer();
            producer.send(queue, messageText);
            resp.getWriter().write("Message sent: " + messageText);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
