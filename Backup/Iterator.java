/*
 * Coded by Teo Yong Zheng and Ng Jia Waie
 * This class implements the iterator pattern
 */
public interface Iterator {
   public boolean hasNext();
   public Action next();
   public int getIndex();
}
