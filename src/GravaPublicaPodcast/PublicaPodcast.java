package GravaPublicaPodcast;

/**
* Classe PublicaPodcast para representar a thread de publicação de um podcast gravado
* 
* @author Gabrielle Brambilla (20201PF.CC0190)
*/

public class PublicaPodcast extends Thread {
    
    Podcast podcast;
    
    public PublicaPodcast(Podcast podcast) {
        this.podcast = podcast;
    }
    
    public void run() {
        
        try {
            
            for (int i = 1; i <= 10; i++) {
                
                System.out.println("Podcast publicado: " + this.podcast.getPodcast());
                Thread.sleep((int) Math.random() * 1000);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}