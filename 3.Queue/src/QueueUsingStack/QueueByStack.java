package QueueUsingStack;

public class QueueByStack {

	//enqueue1==>push(stack1)-->pop(stack1) and push it in stack2.
	//enqueu2==>push(stack1)-->pop(stack2) and push it in stack 1 again poped out from stack1 and pushed it into stack2
	int []array1;
	int []array2;
	int top1,top2;
	int len;
	public QueueByStack(int size) {
		super();
		this.array1 = new int[size];
		this.array2 = new int[size];
     top1=-1;
     top2=-1;
     len=-1;
		//this.top = -1;
	}
	public boolean isEmpty() {
		if (top1 == -1&&top2==-1) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (top1 == array1.length - 1) {
			return true;
		} else {
			return false;
		}

	}
	public void enqueue(int data) {
		if(isFull()) {
			System.out.println("OVERFLOW !!! Can not push new element .");
		}
		else {
			array1[++top1]=data;
			System.out.println(array1[top1]+" pushed succesfully");
		}
	}
	
	public int  dequeue() {
		if(isEmpty()) {
			System.out.println("UNDERFLOW ");
		}
		else if(top2==-1){
			while(top1!=-1) {
				array2[++top2]=array1[top1--];
				
			}
		}
		return array2[top2--];
	}
	/*
	public void enqueue(int data) {
		if(isEmpty()) {
			array1[++top1]=data;//0=>10
			array2[++top2]=array1[top1];//0=>10,top1==0,top2==0
			++len;
			System.out.println(data+" data pushed and poped from stack1 and again push it in stack 2");
			}
		else  {
			//--top1;
			array1[top1]=data;//0=>20......0=>30
			int i=0;
			while(i<=top2) {
				int j=top2;//top2=0,top=1
				array1[++top1]=array2[j--];//top1=1=>10/,top1=1=>20,top=2=>10
				i++;
			}
			while(i<=top1) {//(0<2)
				int k=top1;
				array2[top2]=array1[k--];//top2=0=>10(top1=1),top2=1=>20(top1=0)/
				top2++;
				i++;
			}			
		}	
	}
	*/
	
	public void peek() {
		if(top1==-1) {
			System.out.println("Queue is Empty !!!");
		}
		else {
			System.out.println(array2[top2]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueByStack stack=new QueueByStack(4);
		
		stack.enqueue(30);
		stack.enqueue(20);
		stack.enqueue(10);
		System.out.println(stack.dequeue()+" popped out");
		System.out.println(stack.dequeue()+" popped out");

	   //  stack.peek();

	}

}
