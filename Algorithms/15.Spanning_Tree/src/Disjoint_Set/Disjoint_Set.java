package Disjoint_Set;
/*
 Dis-Joint Set :Two sets are said to be disjoint when they have no common element.
 s1{1,2,3} s2{4,5,6} s3{3,7,8} 
 we will not get anything if we consider the intersection between (s1 & s3 or s2 & s3)these two sets. 
 This is also known as a disjoint set 
 but s1&s3 is not disjoint set because of common element
 */
public class Disjoint_Set {
int[] parent;
int size;
	public Disjoint_Set(int size) {
		this.size=size;
		parent=new int[size];
		makeSet();
	}
	public void makeSet() {
		for(int i=0;i<parent.length;i++) {
			parent[i]=-1;
		}
	}
	//implemented recursively traversing through parent array until hit node who is parent itself
	public int find(int value) {
		if(parent[value]==-1) {
			return value;
		}
		else {
		return find(parent[value]);
		}
	}
	/*
	 * parent  -1, -1, -1, - 1,  -1
	 *   index   0,  1,   2,   3,   4
	 */
	//it helps to merge sets and trees effectively
	public void union(int v1,int v2) {//pass1(0,2),pass2(3,2),pass3(4,1)
		int set1=find(v1);//find(0)=0//find(3)=3//find(4)=4
		int set2=find(v2);//find(2)=2//find(2)=0//find(1)=1
		if(set1>set2) {//3>0(p[3]=0 //-1, -1, 0, 0,  -1 //1, -1, 0, 0,  1
			parent[set1]=set2;
		}
		else if(set1<set2) {//0<2(p[2]=0 ) //-1, -1, 0,- 1,  -1
			parent[set2]=set1;
		}
		else {
			return;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int size=5;
       Disjoint_Set obj=new Disjoint_Set(size);
       obj.union(0,2);
       obj.union(3,2);
       obj.union(4,1);
       if(obj.find(3)==obj.find(0)) {
    	   System.out.println("Same set");
       }
       else {
    	   System.out.println("Not Same set");
       }
       if(obj.find(1)==obj.find(0)) {
    	   System.out.println("Same set");
       }
       else {
    	   System.out.println("Not Same set");
       }
	}

}
