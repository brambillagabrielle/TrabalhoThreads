package GravaPublicaPodcast;

import java.util.concurrent.ArrayBlockingQueue;

/**
* Classe Main para implementar as classes de Thread e BlockingQueue.
* 
* @author Gabrielle Brambilla (20201PF.CC0190)
*/
public class Main {
    
    public static void main(String[] args) {

        ArrayBlockingQueue<String> filaPublicacao = new ArrayBlockingQueue<>(10);
        
        GravaPodcast gravaPodcast = new GravaPodcast(filaPublicacao);
        PublicaPodcast publicaPodcast = new PublicaPodcast(filaPublicacao);

        Thread gravaPodcastThread = new Thread(gravaPodcast);
        Thread publicaPodcastThread = new Thread(publicaPodcast);
        
        gravaPodcastThread.start();
        publicaPodcastThread.start();
        
    }
    
}
