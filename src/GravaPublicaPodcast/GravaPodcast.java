package GravaPublicaPodcast;

/**
* Classe GravaPodcast para representar a thread de gravação de um podcast
* 
* @author Gabrielle Brambilla (20201PF.CC0190)
*/

public class GravaPodcast extends Thread {
    
    Podcast podcast;
    
    public GravaPodcast(Podcast podcast) {
        this.podcast = podcast;
    }
    
    public void run() {
        
        String assunto1[] = {"História dos ", "A grande querra dos ", "Top 10 filmes sobre ",
                    "Resenha: Amor nos tempos dos ", "O que comem os ", "A verdade sobre os ",
                    "Morte e vida dos "};
        String assunto2[] = {"lambaris", "quadrinhos", "agiotas", "piratas",
                    "cupins", "jogares de free fire", "estudantes de direito"};
        
        try {
            
            for (int i = 1; i <= 10; i++) {
                
                this.podcast.setPodcast("Ep #" + i + ": " + assunto1[(int)Math.floor(Math.random()*7)]
                        + assunto2[(int)Math.floor(Math.random()*7)]);
                System.out.println("Episodio " + i + " gravado");
                Thread.sleep((int) Math.random() * 10000);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}