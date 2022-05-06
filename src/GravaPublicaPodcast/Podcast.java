package GravaPublicaPodcast;

/**
* Classe Podcast para representar o próprio podcast
* 
* @author Gabrielle Brambilla (20201PF.CC0190)
*/

public class Podcast {
    
    private String podcast;
    private boolean concluido;
    
    public Podcast() {
        
        this.podcast = podcast;
        this.concluido = false;
        
    }

    public synchronized String getPodcast() {
        
        try {
            
            while(!this.concluido) 
                wait();
            
            this.concluido = false;
            notify();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return podcast;
        
    }

    public synchronized void setPodcast(String podcast) {
        
        try {
        
            while(this.concluido) 
                wait();

            this.podcast = podcast;

            this.concluido = true;
            notify();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    
}
