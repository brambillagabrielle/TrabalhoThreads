package GravaPublicaPodcast;

import java.util.concurrent.ArrayBlockingQueue;

/**
* Classe PublicaPodcast para representar a thread de publicação de um podcast
* gravado.
* 
* @author Gabrielle Brambilla (20201PF.CC0190)
*/
public class PublicaPodcast extends Thread {
    
    private ArrayBlockingQueue<Podcast> getFilaPublicacao;
    private Podcast podcast;
    
    public PublicaPodcast(ArrayBlockingQueue<Podcast> getFilaPublicacao, Podcast podcast) {
        this.getFilaPublicacao = getFilaPublicacao;
        this.podcast = podcast;
    }
    
    public ArrayBlockingQueue<Podcast> getFilaPublicacao() {
        return getFilaPublicacao;
    }

    public Podcast getPodcast() {
        return podcast;
    }

    public void setPodcast(Podcast podcast) {
        this.podcast = podcast;
    }
    
    /**
    * Método mostra a publicação, com o número de episódio e assunto do podcast
    * que foi publicado.
    */
    public void mostraPublicacao(Podcast podcast) {
        System.out.println("Publicado: Ep #" + this.podcast.getEpisodio()
                            + " - " + this.podcast.getAssunto());
    }
    
    /**
    * Método run pertencente à classe Thread, com o código que é executado em
    * paralelo. Nesse caso o código pega podcasts gravados que foram enviados
    * para a fila BlockingQueue (fila de publicação) e publica os episódios.
    */
    @Override
    public void run() {
        
        int episodio = 0;
        
        try {
            
            while (true) {
                
                if (!getFilaPublicacao().isEmpty()) {
                    
                    episodio++;
                    this.podcast.setEpisodio(episodio);
                    
                    setPodcast(getFilaPublicacao().take());
                    mostraPublicacao(podcast);
                    
                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
