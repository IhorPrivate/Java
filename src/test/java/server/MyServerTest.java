package server;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

class MyServerTest {

    @Test
    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws IOException {
        MyServer client = new MyServer();
        client.startConnection("127.0.0.1", 7777);
        String response = client.sendMessage("hello server");
        assertEquals("hello client", response);
    }
}