package GravaPublicaPodcast;

/**
* Classe Main para implementar as classes e threads
* 
* @author Gabrielle Brambilla (20201PF.CC0190)
*/

public class Main {
    
    public static void main(String[] args) {
        
        Podcast podcast = new Podcast();
            
        GravaPodcast threadGrava = new GravaPodcast(podcast);
        threadGrava.start();

        PublicaPodcast threadPublica = new PublicaPodcast(podcast);
        threadPublica.start();
        
    }
    
}