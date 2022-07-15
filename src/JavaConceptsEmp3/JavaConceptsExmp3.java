package JavaConceptsEmp3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JavaConceptsExmp3 {

	//Abstract class declaration
	public abstract class feedbackFormStructure{
		
		HashMap<Integer,String> Questions=new HashMap<Integer,String>();
		
		//Abstract methods
		abstract void insertQuestions();
		abstract void displayQuestions();
	}
	//inheriting abstract class
	public class intern extends feedbackFormStructure{
		//implementing abstract methods
		protected void insertQuestions()
		{
			Questions.put(1,"How is your overall experience with this internship?");
			Questions.put(2,"Do you think your skills have developed after this internship?");
			Questions.put(3,"Will you work at this company if a job is offered ?");
		}
		public void displayQuestions()
		{
			Scanner scan = new Scanner(System.in);
			
			for(Map.Entry q : Questions.entrySet()){    
			    System.out.println(q.getKey()+" . "+q.getValue());    
			    System.out.print("enter your answer: ");
			    String answer = scan.nextLine();
			    //storing feedback in file
			    WritingToFile(answer);
			   }  
		}
	}
	
public class mentor extends feedbackFormStructure{
		
		protected void insertQuestions()
		{
			Questions.put(1,"How is the overall performance of the student within the internship?");
			Questions.put(2,"Do you think your the intern has skills to work in the company?");
			Questions.put(3,"Are you satisfied with the intern performance ?");
		}
		public void displayQuestions()
		{
			Scanner scan = new Scanner(System.in);
			
			for(Map.Entry q : Questions.entrySet()){    
			    System.out.println(q.getKey()+" . "+q.getValue());    
			    System.out.print("enter your answer : ");
			    String answer = scan.nextLine();
			    WritingToFile(answer);
			   }  
		}
	}
	
	private static void WritingToFile(String data)
	{
		//Using Exceptions
		try {  
	        FileWriter fwrite = new FileWriter("C:\\Users\\mahi0\\Documents\\FeedbackAnswers.txt",true);  
	        // writing the content into the FileOperationExample.txt file  
	        fwrite.write("\n"+data);   
	   
	        // Closing the stream  
	        fwrite.close();  
	    } catch (IOException e) {  
	        System.out.println("Unexpected error occurred while saving your response");  
	        e.printStackTrace();  
	        }  
	}
	
	public static void main(String[] args)
	{
		
		JavaConceptsExmp3 obj = new JavaConceptsExmp3();
		intern obj2 = obj.new intern();
		mentor obj3 = obj.new mentor();
		
		Scanner scan = new Scanner(System.in);
		 System.out.println("Enter your name");
		 String name = scan.nextLine();
		 WritingToFile(name);
		 
		 System.out.println("Are you an intern or mentor ?");
		 String role=scan.nextLine();
		 switch(role) {
			 case "intern":
				 WritingToFile("Intern feedback");
				 obj2.insertQuestions();
				 obj2.displayQuestions();
			 case "mentor":
				 WritingToFile("Mentor feedback");
				 obj3.insertQuestions();
				 obj3.displayQuestions();
		 } 
		 
		 System.out.println("Feedback finished successfully");	
	}
}
