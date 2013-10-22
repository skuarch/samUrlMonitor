package model.common;

import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class ThreadKiller {
    
    private static final Logger logger = Logger.getLogger(ThreadKiller.class);

    //==========================================================================
    public ThreadKiller() {
    }

    //==========================================================================
    public void killThread(long id) {
        
        int numThreads = 0;
        Thread[] threads = null;
        
        try {   
            
            ThreadGroup tgRoot = null;
            ThreadGroup tg = Thread.currentThread().getThreadGroup();
            ThreadGroup tgp = tg.getParent();
            
            while (tgp.getParent() != null) {
                tgRoot = tgRoot.getParent();
            }
            
            numThreads = tgRoot.activeCount();
            threads = new Thread[numThreads * 2];            
            numThreads = tgRoot.enumerate(threads, false);
            
            for (int i = 0; i < numThreads; i++) {
                
                Thread thread = threads[i];
                
                if (thread.getId() == id) {
                    thread.stop();
                    thread.interrupt();
                    thread.destroy();
                    thread = null;
                }
                
            }
            
        } catch (Exception e) {
            logger.error("threadKiller", e);
        }
        
    } // end killThread
} // end class