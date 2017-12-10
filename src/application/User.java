package application;

import java.io.Serializable;

class User implements Serializable{

	    private long userId;
	    private String email;
	    private String username;
	    private String name;
	    private int age;
	    private String gender;
	    private String password;
	    public User(String email,String username, String name, int age, String gender, String password){
	    	this.email = email;
	    	this.username = username;
	    	this.name = name;
	    	this.age = age;
	    	this.gender = gender;
	    	this.password = password;
	    }
	    
	    public User(String username, String password){
	    	this.username = username;
	    	this.password = password;
	    }
	    
	    public long getUserId(){
	    	return userId;
	    }
	    
	    public void setUserId(long userId){
	    	this.userId = userId;
	    }
	    
	    public String getName(){
	    	return name;
	    }
	    
	    public void setName(String name){
	    	this.name = name;
	    }
	    public int getAge(){
	    	return age;
	    }
	    
	    public void setAge(int age){
	    	this.age = age;
	    }
	    public String getGender(){
	    	return gender;
	    }
	    
	    public void setGender(String gender){
	    	this.gender = gender;
	    }
	    public String getPassword(){
	    	return password;
	    }
	    
	    public void setPassword(String password){
	    	this.password = password;
	    }
	    public String getUsername(){
	    	return username;
	    }
	    
	    public void setUsername(String username){
	    	this.username = username;
	    }
	    
	    public String getEmail(){
	    	return email;
	    }
	    
	    public void setEmail(String email){
	    	this.email = email;
	    }

	    
	    
	}


