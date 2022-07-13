void depthFirst(Consumer<TreeNode<T>> visit)
{
    visit.accept(this);
    for (TreeNode<T> child : children)
        child.depthFirst(visit);
}

void breadthFirst(Consumer<TreeNode<T>> visit)
{ 
    visit.accept(this);
    ArrayList<TreeNode<T>> queue = new ArrayList<TreeNode<T>>();
    for (TreeNode<T> child : children)
        queue.add(child);
    
    int idx = 0;
    while (idx < queue.size())
    {
        TreeNode<T> currentChild = queue.get(idx);
        visit.accept(currentChild);
        idx += 1;
        for (TreeNode<T> grandChild : currentChild.children)
            queue.add(grandChild);
    }   
}

public String[] serialize()
{	
    int maxValueCount = (int) Math.pow(2, (this.hoehe()+1))-1;
    String values[] = new String[maxValueCount];
    _recSerialize(values,this);
    valueCnt=0;
    return values;
}
public void _recSerialize(String[]values,BinaryNode<T> node )
{
    if(node == null) {
        valueCnt++;
    }
    else {
        values[valueCnt++]= node.getValue().toString();
        _recSerialize(values,node.leftChild);
        _recSerialize(values,node.rightChild);
    }
}

public void printSerialize()
{
    String[] tmp = this.serialize();
    for(String s : tmp)
    {
        System.out.print(s+" , " );
    }
    System.out.println();
}
public BinaryNode<Integer> deserialize(String[] values) {
    BinaryNode<Integer> root = new BinaryNode<Integer>(Integer.valueOf(values[valueCnt]));
    root.leftChild	= _deserializeRec(values);//linken baum bauen
    root.rightChild	= _deserializeRec(values);//rechten baum bauen
    valueCnt=0;
    return root;
}
public BinaryNode<Integer> _deserializeRec(String[] values) {
    valueCnt++;
    if(values[valueCnt]!=null)
    {
        BinaryNode<Integer> node = new BinaryNode<Integer>(Integer.valueOf(values[valueCnt]));
        node.leftChild	= _deserializeRec(values);
        node.rightChild	= _deserializeRec(values);
        return node;
    }
    else return null;
    
}

public void printByLevel(Consumer<TreeNode<T>> cons)
{
    cons.accept(this);   
    ArrayList<TreeNode<T>> queue = new ArrayList<TreeNode<T>>();
    queue.addAll(children);
    ArrayList<TreeNode<T>> input_lvl = new ArrayList<TreeNode<T>>();
    input_lvl.addAll(children);
    while (!input_lvl.isEmpty()) {     
        ArrayList<TreeNode<T>> output_lvl = new ArrayList<TreeNode<T>>();
        for (int i = 0; i < input_lvl.size(); i++)
            input_lvl.get(i).children.forEach(output_lvl::add);

        input_lvl.clear();
        input_lvl.addAll(output_lvl);

        queue.addAll(output_lvl);
        queue.forEach(cons::accept);
    }
}
public boolean isInTree(T value)
{	
	ArrayList<TreeNode<T>> queue = new ArrayList<TreeNode<T>>();
	for (TreeNode<T> child : children)
		queue.add(child);
		
	int idx = 0;
	while (idx < queue.size())
	{
		TreeNode<T> currentChild = queue.get(idx);	
		if(currentChild.getValue().equals(value))return true;	
		idx += 1;
		for (TreeNode<T> grandChild : currentChild.children)
			queue.add(grandChild);
	}
	return false;
} 

public class Hanoi {
	void solveTower(int discs, String from, String to, String free)
	{
		if(discs == 1){
			System.out.println("Bewege Scheibe von <" + from + "> nach <" + to + ">");
		} else{
			solveTower(discs-1, from, free, to);
			System.out.println("Bewege Scheibe von <" + from + "> nach <" + to + ">");
			solveTower(discs-1, free, to, from);
		}
	}	
	public static void main(String[] args) {
		Hanoi solver = new Hanoi();
			
		solver.solveTower(5, "A", "C", "B");
	}
}

private AVLNode<T> leftRotation(AVLNode<T> node)
{
    AVLNode<T> pivot = node.rightChild;
    node.rightChild = pivot.leftChild;
    pivot.leftChild = node;
    
    node.height = Math.max(node.leftHeight(), node.rightHeight()) + 1;
    pivot.height = Math.max(pivot.leftHeight(), pivot.rightHeight()) + 1;
    
    return pivot;
}

public Boolean cuckoHashingAdd(T value)
{
    T toBeInserted = value;
    T contentBefore;
    
    int cnt = 0;
    if (isIn(value)) return false;  
    while (cnt < hashTableSize) {
        
        contentBefore = hashTable0.get(toBeInserted.hash0());
        hashTable0.set(toBeInserted.hash0(), toBeInserted);
        if (contentBefore == null) return true;
        
        toBeInserted = contentBefore;
        contentBefore = hashTable1.get(toBeInserted.hash1());
        hashTable1.set(toBeInserted.hash1(), toBeInserted);
        if (contentBefore == null) return true;

        toBeInserted = contentBefore;
        
        cnt += 1;
    }
    return false;
}