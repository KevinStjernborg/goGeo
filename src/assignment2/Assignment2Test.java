package assignment2;



public class Assignment2Test {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Buffer<Character> buffer = new Buffer<Character>();
		Writer writer = new Writer(buffer);
		Reader reader = new Reader(buffer);
		JGUIAssignment2 test = new JGUIAssignment2();
		test.setReader(reader);
		test.setWriter(writer);

		test.Start();
	}
}
