package application;
	import java.io.*;
	import java.util.*;

	public class Registry  {

	    private static HashMap<Long,User> userMap = new HashMap<Long,User>();
	    private static final String savedData = new String("art.dat"); // file containing the users
	    
	    public Registry(){
	    	userMap = new HashMap<Long,User>();
	    }
	    
	    

	    // build up the database from the file DB
	    public Registry(String filename) throws FileNotFoundException,
	                           IOException {
	        openFile(savedData);
	    }


	    public void adding(User user)
	                        throws IllegalArgumentException{

	        if (userMap.containsKey(user.getUserId())) {
	            
	            throw new IllegalArgumentException(
	                "User with the same ID already exists");
	                
	        } else {
	            userMap.put(user.getUserId(), user);
	        }
	    }

	    public void remove(long id) {
	        userMap.remove(id);
	    }

	    public User retrieving(long id) {
	        return userMap.get(id);
	    }
	    
	    // start by loading the DB into the user table
	    public void start() {
		try {
		    openFile(savedData);
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }

	    // end by dumping the current user table into DB
	    public void write2DB() {
		try {
		    storing(savedData);
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }

	    public String getUserList( ) {
	        StringBuffer result = new StringBuffer("");
	        String tab = "\t";
	        String newLine = "\n";       
	        for (User u : userMap.values()){
	            result.append(u.getUserId()     + tab +
	                          u.getName()     + tab +
	                          u.getPassword() + tab +
	                          newLine);
	        }

	        return result.toString();
	    }


	    public void openFile(String filename)
	                    throws FileNotFoundException,
	                           IOException {      
	        FileInputStream inFileStream =
	                    new FileInputStream( new File(filename));
	                    
	        ObjectInputStream inObjectStream =
	                    new ObjectInputStream(inFileStream);

	        try {
	            userMap = (HashMap<Long,User>) inObjectStream.readObject();           
	        } catch (ClassNotFoundException e) {
	            throw new IOException("Unrecognized data in the designated file");
	        }
	        inObjectStream.close();

	    }

	    public void storing(String filename)
	                    throws IOException {
	        
	        FileOutputStream outFileStream =
	                 new FileOutputStream(savedData);
	        
	                 
	        ObjectOutputStream outObjectStream =
	                 new ObjectOutputStream(outFileStream);
	        
	        PrintWriter out = new PrintWriter(new FileWriter(savedData, true));
	        //out.append("******* " + timeStamp.toString() +"******* " + "\n");

	        outObjectStream.writeObject(userMap);
	        outObjectStream.close();
	    }
	    
	    
	    
	    static String bbc = "invalid user";
	    public static boolean  VerifyUser(User z){
	    	for(User b: userMap.values()){
	    		System.out.println(b.getUserId());
	    		if(z.getUsername().equals(b.getUsername())){
	    			System.out.println("Valid username");
	    			if(z.getPassword().equals(b.getPassword())){
	    				System.out.println("Valid password");
	    			}
	    		}
	    	}
	    	return true;
	    }
	    
	    
	    
	    
	    
	    
//	    public boolean VerifyUser(String u, St){
//	    		for (User vUser : userTable.values()) {
//	    		    System.out.println(vUser.getUserId);
//	    		    if(vUser.getUsername().equals(u.getUsername) && (vUser.getPassword().equals(p.getPassword))){
//	    		    	return true;
//	    }    
//		    	
//	    		
//	    	
//	    	return false;
//	    		}
//	    }
	

//	    public User createUserFromInput( ) {
//	        Scanner sc = new Scanner(System.in);
//	        System.out.print("Enter ID:");
//	        long userID = sc.nextLong();       
//	        
//	        System.out.print("Enter name:");
//	        String name = sc.next();
//	        
//	        System.out.print("Enter Password:");
//	        String password  = sc.next();
//		return new User(name, password);
//	    }
//
//	    // create users by the keyboard
//	    // This has no validation and needs be improved
//	    public void processInputData( ) {
//		boolean done = false;
//	        int counter = 1;
//		 while (!done) {           
//	            User u = createUserFromInput(); 
//		    addUser(u);
//	            counter++;
//	            if (counter > 3) done = true;
//		 }
//		 
//	        
	    

	}


