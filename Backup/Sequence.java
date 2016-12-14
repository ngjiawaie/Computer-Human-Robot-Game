/*
 * Coded by Teo Yong Zheng and Ng Jia Waie
 * This class implements the Iterator Pattern
 */
class Sequence implements Container, java.io.Serializable{
	private int totalSequence;
	private int currentIndex = -1;
	private Action[] action;
	
	Sequence(int totalSequence){
		this.totalSequence = totalSequence;
		action = new Action[totalSequence];
	}
	
	public Iterator getIterator(){
		return new SequenceIterator();
	}

	boolean addAction(Action action){
		if (currentIndex< totalSequence-1) {	
			currentIndex++;
			this.action[currentIndex] = action;
			return true;
		}
		return false;
	}

	public boolean undoAction(){
		//reverse the index by 1
		//doesn't actually "delete" the data but replacing it.
		if (currentIndex != -1) {
			currentIndex--;
			return true;
		}
		return false;
	}

	public int getSequenceCount(){
		return currentIndex+1;
	}
	
	public boolean isFull(){
		return totalSequence-1 == currentIndex;
	}
	
	void clear(){
		currentIndex = -1;
	}

	
	class SequenceIterator implements Iterator{
		int index=0; 
		public boolean hasNext(){

			if (index <= currentIndex){
				return true;
			} 
			else{
				return false;
			}

		}
		
		public int getIndex(){
			return index;
		}
		
		public Action next(){

		   if (hasNext()){
		   		return action[index++];
		   }
		   else{ 
		   		return null;
		   }

		}
	}

}