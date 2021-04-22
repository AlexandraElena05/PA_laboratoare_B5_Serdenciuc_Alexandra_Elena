import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
    private static final  PersistenceManager pm = new PersistenceManager();
    protected EntityManagerFactory emf;

    private PersistenceManager(){

    }

    public static PersistenceManager getInstance(){
        return pm;
    }

    public EntityManagerFactory getEmf() {
        if(emf == null)
            createEmf();
        return emf;

    }

    protected void createEmf() {
        this.emf = Persistence.createEntityManagerFactory("default");
    }

    public void closeEmf(){
        if(emf != null)
            emf.close();
        emf=null;
    }

}
