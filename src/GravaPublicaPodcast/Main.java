package GravaPublicaPodcast;

import java.util.concurrent.ArrayBlockingQueue;

/**
* Classe Main para implementar as classes de Thread e BlockingQueue.
* 
* @author Gabrielle Brambilla (20201PF.CC0190)
*/
public class Main {
    
    public static void main(String[] args) {
        
        Podcast podcast = new Podcast();

        ArrayBlockingQueue<Podcast> filaPublicacao = new ArrayBlockingQueue<>(10);
        
        GravaPodcast gravaPodcast = new GravaPodcast(filaPublicacao, podcast);
        PublicaPodcast publicaPodcast = new PublicaPodcast(filaPublicacao, podcast);

        Thread gravaPodcastThread = new Thread(gravaPodcast);
        Thread publicaPodcastThread = new Thread(publicaPodcast);
        
        gravaPodcastThread.start();
        publicaPodcastThread.start();
        
    }
    
}
