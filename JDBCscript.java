
import java.sql.*; //JDBC packages
import java.math.*;
import java.io.*;
import oracle.jdbc.driver.*;

public class JDBCscript{
	public static void main(String[] args) throws Exception{
			String username = "username";
			String password = "password";
			JDBCexample(username,password);
	}	
	
	public static void JDBCexample(String userid, String passwd) throws Exception {
		String[] tables = new String[]{"Member", "Profile", "Movie", "Actor", "Genre", "Has", "Watch", "Likes", "Movie_Genre", "Starred_By"};
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu", userid, passwd);
			
			//main execution loop
			while(true){
				System.out.println("Please enter command, type Help for help and Exit to exit");
				String input = System.console().readLine();
				
				
				//Help Command
				if(input.equals("Help")){
					System.out.println("Commands: \nHelp: Displays help message\nDisplay: Displays a table from the database\nInsert: Inserts a new record into database\nUpdate: Updates or deletes an existing record in the database\nSearch: Searches for a movie in the database\nProfile: Shows the rental history of a profile in the database\nExit: Exits the program\n");
					continue;
				}
				
				
				//Display Command
				if(input.equals("Display")){
					System.out.println("Enter the name of the table you wish to view\nMember, Profile, Movie, Actor, Genre, Has, Watch, Likes, Movie_Genre, Starred_By");
					input = System.console().readLine();
					
					if(input.equals("Member")){
						String sql = "SELECT * FROM " + input;
						PreparedStatement pStmt = conn.prepareStatement(sql);
						ResultSet rset = pStmt.executeQuery();
						while (rset.next()){
							System.out.println(rset.getString(1) + " " + rset.getString(2) + " " +rset.getString(3) + " " +rset.getString(4) + " " + rset.getInt(5));
						}
						rset.close();
						pStmt.close();
						continue;
					}
					
					if(input.equals("Profile")){
						String sql = "SELECT * FROM " + input;
						PreparedStatement pStmt = conn.prepareStatement(sql);
						ResultSet rset = pStmt.executeQuery();
						while (rset.next()){
							System.out.println(rset.getString(1) + " " + rset.getString(2));
						}
						rset.close();
						pStmt.close();
						continue;
					}
					
					if(input.equals("Movie")){
						String sql = "SELECT * FROM " + input;
						PreparedStatement pStmt = conn.prepareStatement(sql);
						ResultSet rset = pStmt.executeQuery();
						while (rset.next()){
							System.out.println(rset.getString(1) + " " + rset.getString(2) + " " +rset.getInt(3) + " " +rset.getString(4) + " " + rset.getInt(5));
						}
						rset.close();
						pStmt.close();
						continue;	
					}
					
					if(input.equals("Actor")){
						String sql = "SELECT * FROM " + input;
						PreparedStatement pStmt = conn.prepareStatement(sql);
						ResultSet rset = pStmt.executeQuery();
						while (rset.next()){
							System.out.println(rset.getString(1) + " " + rset.getString(2) + " " +rset.getString(3));
						}
						rset.close();
						pStmt.close();
						continue;	
					}
					
					if(input.equals("Genre")){
						String sql = "SELECT * FROM " + input;
						PreparedStatement pStmt = conn.prepareStatement(sql);
						ResultSet rset = pStmt.executeQuery();
						while (rset.next()){
							System.out.println(rset.getString(1));
						}
						rset.close();
						pStmt.close();
						continue;	
					}
					
					if(input.equals("Has")){
						String sql = "SELECT * FROM " + input;
						PreparedStatement pStmt = conn.prepareStatement(sql);
						ResultSet rset = pStmt.executeQuery();
						while (rset.next()){
							System.out.println(rset.getString(1) + " " + rset.getString(2));
						}
						rset.close();
						pStmt.close();
						continue;	
					}
					
					if(input.equals("Watch")){
						String sql = "SELECT * FROM " + input;
						PreparedStatement pStmt = conn.prepareStatement(sql);
						ResultSet rset = pStmt.executeQuery();
						while (rset.next()){
							System.out.println(rset.getString(1) + " " + rset.getString(2) + " " +rset.getString(3) + " " + rset.getInt(4));
						}
						rset.close();
						pStmt.close();
						continue;
					}
					
					if(input.equals("Likes")){
						String sql = "SELECT * FROM " + input;
						PreparedStatement pStmt = conn.prepareStatement(sql);
						ResultSet rset = pStmt.executeQuery();
						while (rset.next()){
							System.out.println(rset.getString(1) + " " + rset.getString(2) + " " +rset.getString(3));
						}
						rset.close();
						pStmt.close();
						continue;
					}
					
					if(input.equals("Movie_Genre")){
						String sql = "SELECT * FROM " + input;
						PreparedStatement pStmt = conn.prepareStatement(sql);
						ResultSet rset = pStmt.executeQuery();
						while (rset.next()){
							System.out.println(rset.getString(1) + " " + rset.getString(2));
						}
						rset.close();
						pStmt.close();
						continue;
					}
					
					if(input.equals("Starred_By")){
						String sql = "SELECT * FROM " + input;
						PreparedStatement pStmt = conn.prepareStatement(sql);
						ResultSet rset = pStmt.executeQuery();
						while (rset.next()){
							System.out.println(rset.getString(1) + " " + rset.getString(2));
						}
						rset.close();
						pStmt.close();
						continue;
					}
					
					System.out.println("Invalid Input");
					continue;
				}
				
				
				//Insert Command
				if(input.equals("Insert")){
					System.out.println("Enter the table that you are inserting into\nMember, Profile, Movie, Actor, Genre, Has, Watch, Likes, Movie_Genre, Starred_By");
					input = System.console().readLine();
					String input1, input2, input3, input4, input5;
					if(input.equals("Member")){
						System.out.println("Enter the Member_ID");
						input1 = System.console().readLine();
						System.out.println("Enter the first_Name");
						input2 = System.console().readLine();
						System.out.println("Enter the last_Name");
						input3 = System.console().readLine();
						System.out.println("Enter the card_number");
						input4 = System.console().readLine();
						System.out.println("Enter the exp_date");
						input5 = System.console().readLine();
						
						String sql = "INSERT INTO " + input + " VALUES(?,?,?,?,?)";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						pStmt.setString(1, input1);
						pStmt.setString(2, input2);
						pStmt.setString(3, input3);
						pStmt.setString(4, input4);
						pStmt.setString(5, input5);
						boolean checker = true;
						try{
							pStmt.executeUpdate();
						}	
						catch (SQLException sqle) {
							System.out.println("SQLException : " + sqle);
							checker = false;
						}
						if(checker){
							System.out.println("Record Inserted");
						}
						pStmt.close();
						continue;
					}
					
					if(input.equals("Profile")){
						System.out.println("Enter the Member_ID");
						input1 = System.console().readLine();
						System.out.println("Enter the profile_Name");
						input2 = System.console().readLine();
						
						String sql = "INSERT INTO " + input + " VALUES(?,?)";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						pStmt.setString(1, input1);
						pStmt.setString(2, input2);
						boolean checker = true;
						try{
							pStmt.executeUpdate();
						}	
						catch (SQLException sqle) {
							System.out.println("SQLException : " + sqle);
							checker = false;
						}
						if(checker){
							System.out.println("Record Inserted");
						}
						pStmt.close();
						continue;
					}
					
					if(input.equals("Movie")){
						System.out.println("Enter the movie_ID");
						input1 = System.console().readLine();
						System.out.println("Enter the title");
						input2 = System.console().readLine();
						System.out.println("Enter the movie_year");
						input3 = System.console().readLine();
						System.out.println("Enter the producer");
						input4 = System.console().readLine();
						System.out.println("Enter the avg_rating");
						input5 = System.console().readLine();
						
						String sql = "INSERT INTO " + input + " VALUES(?,?,?,?,?)";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						pStmt.setString(1, input1);
						pStmt.setString(2, input2);
						pStmt.setString(3, input3);
						pStmt.setString(4, input4);
						pStmt.setString(5, input5);
						boolean checker = true;
						try{
							pStmt.executeUpdate();
						}	
						catch (SQLException sqle) {
							System.out.println("SQLException : " + sqle);
							checker = false;
						}
						if(checker){
							System.out.println("Record Inserted");
						}
						pStmt.close();
						continue;
					}
					
					if(input.equals("Actor")){
						System.out.println("Enter the Actor_ID");
						input1 = System.console().readLine();
						System.out.println("Enter the first_Name");
						input2 = System.console().readLine();
						System.out.println("Enter the last_Name");
						input3 = System.console().readLine();
						
						String sql = "INSERT INTO " + input + " VALUES(?,?,?)";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						pStmt.setString(1, input1);
						pStmt.setString(2, input2);
						pStmt.setString(3, input3);
						boolean checker = true;
						try{
							pStmt.executeUpdate();
						}	
						catch (SQLException sqle) {
							System.out.println("SQLException : " + sqle);
							checker = false;
						}
						if(checker){
							System.out.println("Record Inserted");
						}
						pStmt.close();
						continue;
					}
					
					if(input.equals("Genre")){
						System.out.println("Enter the m_genre");
						input1 = System.console().readLine();
						
						String sql = "INSERT INTO " + input + " VALUES(?)";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						pStmt.setString(1, input1);
						boolean checker = true;
						try{
							pStmt.executeUpdate();
						}	
						catch (SQLException sqle) {
							System.out.println("SQLException : " + sqle);
							checker = false;
						}
						if(checker){
							System.out.println("Record Inserted");
						}
						pStmt.close();
						continue;									
					}
					
					if(input.equals("Has")){
						System.out.println("Enter the Member_ID");
						input1 = System.console().readLine();
						System.out.println("Enter the profile_name");
						input2 = System.console().readLine();
						
						String sql = "INSERT INTO " + input + " VALUES(?,?)";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						pStmt.setString(1, input1);
						pStmt.setString(2, input2);
						boolean checker = true;
						try{
							pStmt.executeUpdate();
						}	
						catch (SQLException sqle) {
							System.out.println("SQLException : " + sqle);
							checker = false;
						}
						if(checker){
							System.out.println("Record Inserted");
						}
						pStmt.close();
						continue;							
					}
					
					if(input.equals("Watch")){
						System.out.println("Enter the Member_ID");
						input1 = System.console().readLine();
						System.out.println("Enter the profile_name");
						input2 = System.console().readLine();
						System.out.println("Enter the movie_ID");
						input3 = System.console().readLine();
						System.out.println("Enter the rating");
						input4 = System.console().readLine();
						
						String sql = "INSERT INTO " + input + " VALUES(?,?,?,?)";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						pStmt.setString(1, input1);
						pStmt.setString(2, input2);
						pStmt.setString(3, input3);
						pStmt.setString(4, input4);
						boolean checker = true;
						try{
							pStmt.executeUpdate();
						}	
						catch (SQLException sqle) {
							System.out.println("SQLException : " + sqle);
							checker = false;
						}
						if(checker){
							System.out.println("Record Inserted");
						}
						pStmt.close();
						continue;		
					}
					
					if(input.equals("Likes")){
						System.out.println("Enter the Member_ID");
						input1 = System.console().readLine();
						System.out.println("Enter the profile_name");
						input2 = System.console().readLine();
						System.out.println("Enter the m_genre");
						input3 = System.console().readLine();
						
						String sql = "INSERT INTO " + input + " VALUES(?,?,?)";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						pStmt.setString(1, input1);
						pStmt.setString(2, input2);
						pStmt.setString(3, input3);
						boolean checker = true;
						try{
							pStmt.executeUpdate();
						}	
						catch (SQLException sqle) {
							System.out.println("SQLException : " + sqle);
							checker = false;
						}
						if(checker){
							System.out.println("Record Inserted");
						}
						pStmt.close();
						continue;								
					}
					
					if(input.equals("Movie_Genre")){
						System.out.println("Enter the m_genre");
						input1 = System.console().readLine();
						System.out.println("Enter the movie_ID");
						input2 = System.console().readLine();
						
						String sql = "INSERT INTO " + input + " VALUES(?,?)";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						pStmt.setString(1, input1);
						pStmt.setString(2, input2);
						boolean checker = true;
						try{
							pStmt.executeUpdate();
						}	
						catch (SQLException sqle) {
							System.out.println("SQLException : " + sqle);
							checker = false;
						}
						if(checker){
							System.out.println("Record Inserted");
						}
						pStmt.close();
						continue;								
					}
					
					if(input.equals("Starred_By")){
						System.out.println("Enter the movie_ID");
						input1 = System.console().readLine();
						System.out.println("Enter the actor_ID");
						input2 = System.console().readLine();
						
						String sql = "INSERT INTO " + input + " VALUES(?,?)";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						pStmt.setString(1, input1);
						pStmt.setString(2, input2);
						boolean checker = true;
						try{
							pStmt.executeUpdate();
						}	
						catch (SQLException sqle) {
							System.out.println("SQLException : " + sqle);
							checker = false;
						}
						if(checker){
							System.out.println("Record Inserted");
						}
						pStmt.close();
						continue;									
					}
					System.out.println("Invalid Input");
					continue;
				}
				
				
				//Update Command
				if(input.equals("Update")){
					System.out.println("Enter Update to update information or Delete to delete a record");
					input = System.console().readLine();
					String input2,input3,column,value;
					if(input.equals("Update")){
						System.out.println("Enter the name of the table you wish to update\nMember, Profile, Movie, Actor, Genre, Has, Watch, Likes, Movie_Genre, Starred_By");
						input = System.console().readLine();
						
						if(input.equals("Member")){
							System.out.println("Enter the Member_ID");
							input = System.console().readLine();
							
							System.out.println("Enter the name of the column you want to edit");
							column = System.console().readLine();
							System.out.println("Enter the new value for said column");
							value = System.console().readLine();
							String sql = "UPDATE Member SET " + column + " = ? WHERE Member_ID = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1, value);
							pStmt.setString(2,input);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Updated");
							}
							pStmt.close();
							continue;
						}
						
						if(input.equals("Profile")){
							System.out.println("Enter the Member_ID");
							input = System.console().readLine();
							System.out.println("Enter the Profile_Name");
							input2 = System.console().readLine();

							System.out.println("Enter the name of the column you want to edit");
							column = System.console().readLine();
							System.out.println("Enter the new value for said column");
							value = System.console().readLine();
							String sql = "UPDATE Profile SET " + column + " = ? WHERE Member_ID = ? and Profile_Name = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1, value);
							pStmt.setString(2,input);
							pStmt.setString(3,input2);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Updated");
							}
							pStmt.close();
							continue;
						}
						
						if(input.equals("Movie")){
							System.out.println("Enter the Movie_ID");
							input = System.console().readLine();
							
							System.out.println("Enter the name of the column you want to edit");
							column = System.console().readLine();
							System.out.println("Enter the new value for said column");
							value = System.console().readLine();
							String sql = "UPDATE Movie SET " + column + " = ? WHERE Movie_ID = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1, value);
							pStmt.setString(2,input);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Updated");
							}
							pStmt.close();
							continue;
						}
						
						if(input.equals("Actor")){
							System.out.println("Enter the Actor_ID");
							input = System.console().readLine();
							
							System.out.println("Enter the name of the column you want to edit");
							column = System.console().readLine();
							System.out.println("Enter the new value for said column");
							value = System.console().readLine();
							String sql = "UPDATE Actor SET " + column + " = ? WHERE Actor_ID = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1, value);
							pStmt.setString(2,input);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Updated");
							}
							pStmt.close();
							continue;							
						}
						
						if(input.equals("Genre")){
							System.out.println("Enter the M_Genre");
							input = System.console().readLine();
							System.out.println("Enter the name of the column you want to edit");
							column = System.console().readLine();
							System.out.println("Enter the new value for said column");
							value = System.console().readLine();
							String sql = "UPDATE Genre SET " + column + " = ? WHERE M_Genre = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1, value);
							pStmt.setString(2,input);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Updated");
							}
							pStmt.close();
							continue;									
						}
						
						if(input.equals("Has")){
							System.out.println("Enter the Member_ID");
							input = System.console().readLine();
							System.out.println("Enter the profile_name");
							input2 = System.console().readLine();

							System.out.println("Enter the name of the column you want to edit");
							column = System.console().readLine();
							System.out.println("Enter the new value for said column");
							value = System.console().readLine();
							String sql = "UPDATE Has SET " + column + " = ? WHERE Member_ID = ? and Profile_Name = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1, value);
							pStmt.setString(2,input);
							pStmt.setString(3,input2);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Updated");
							}
							pStmt.close();
							continue;							
						}
						
						if(input.equals("Watch")){
							System.out.println("Enter the Member_ID");
							input = System.console().readLine();
							System.out.println("Enter the Profile_Name");
							input2 = System.console().readLine();
							System.out.println("Enter the Movie_ID");
							input3 = System.console().readLine();
							
							System.out.println("Enter the name of the column you want to edit");
							column = System.console().readLine();
							System.out.println("Enter the new value for said column");
							value = System.console().readLine();
							String sql = "UPDATE Watch SET " + column + " = ? WHERE Member_ID = ? and Profile_Name = ? and Movie_ID = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1, value);
							pStmt.setString(2,input);
							pStmt.setString(3,input2);
							pStmt.setString(4,input3);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Updated");
							}
							pStmt.close();
							continue;			
						}
						
						if(input.equals("Likes")){
							System.out.println("Enter the Member_ID");
							input = System.console().readLine();
							System.out.println("Enter the Profile_Name");
							input2 = System.console().readLine();
							System.out.println("Enter the m_genre");
							input3 = System.console().readLine();	

							System.out.println("Enter the name of the column you want to edit");
							column = System.console().readLine();
							System.out.println("Enter the new value for said column");
							value = System.console().readLine();
							String sql = "UPDATE Likes SET " + column + " = ? WHERE Member_ID = ? and Profile_Name = ? and m_genre = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1, value);
							pStmt.setString(2,input);
							pStmt.setString(3,input2);
							pStmt.setString(4,input3);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Updated");
							}
							pStmt.close();
							continue;										
						}
						
						if(input.equals("Movie_Genre")){
							System.out.println("Enter the m_genre");
							input = System.console().readLine();
							System.out.println("Enter the Movie_ID");
							input2 = System.console().readLine();

							System.out.println("Enter the name of the column you want to edit");
							column = System.console().readLine();
							System.out.println("Enter the new value for said column");
							value = System.console().readLine();
							String sql = "UPDATE Movie_Genre SET " + column + " = ? WHERE M_genre = ? and Movie_ID = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1, value);
							pStmt.setString(2,input);
							pStmt.setString(3,input2);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Updated");
							}
							pStmt.close();
							continue;									
						}
						
						if(input.equals("Starred_By")){
							System.out.println("Enter the Member_ID");
							input = System.console().readLine();
							System.out.println("Enter the Actor_ID");
							input2 = System.console().readLine();

							System.out.println("Enter the name of the column you want to edit");
							column = System.console().readLine();
							System.out.println("Enter the new value for said column");
							value = System.console().readLine();
							String sql = "UPDATE Starred_By SET " + column + " = ? WHERE Member_ID = ? and Actor_ID = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1, value);
							pStmt.setString(2,input);
							pStmt.setString(3,input2);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Updated");
							}
							pStmt.close();
							continue;									
						}
						System.out.println("Invalid Input");
						continue;
					}
					
					//Delete Command
					if(input.equals("Delete")){
						System.out.println("Enter the name of the table to delete a record from\nMember, Profile, Movie, Actor, Genre, Has, Watch, Likes, Movie_Genre, Starred_By");
						input = System.console().readLine();
						
						if(input.equals("Member")){
							System.out.println("Enter the Member_ID");
							input = System.console().readLine();
							
							String sql = "DELETE FROM Member WHERE Member_ID = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1,input);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Deleted");
							}
							pStmt.close();
							continue;
						}
						
						if(input.equals("Profile")){
							System.out.println("Enter the Member_ID");
							input = System.console().readLine();
							System.out.println("Enter the Profile_Name");
							input2 = System.console().readLine();

							String sql = "DELETE FROM Profile WHERE Member_ID = ? and Profile_Name = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1,input);
							pStmt.setString(2,input2);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Deleted");
							}
							pStmt.close();
							continue;
						}
						
						if(input.equals("Movie")){
							System.out.println("Enter the Movie_ID");
							input = System.console().readLine();
							
							String sql = "DELETE FROM Movie WHERE Movie_ID = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1,input);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Deleted");
							}
							pStmt.close();
							continue;
						}
						
						if(input.equals("Actor")){
							System.out.println("Enter the Actor_ID");
							input = System.console().readLine();
							
							String sql = "DELETE FROM Actor WHERE Actor_ID = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1,input);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Deleted");
							}
							pStmt.close();
							continue;
						}
						
						if(input.equals("Genre")){
							System.out.println("Enter the M_Genre");
							input = System.console().readLine();
							
							String sql = "DELETE FROM Genre WHERE M_Genre = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1,input);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Deleted");
							}
							pStmt.close();
							continue;								
						}
						
						if(input.equals("Has")){
							System.out.println("Enter the Member_ID");
							input = System.console().readLine();
							System.out.println("Enter the profile_name");
							input2 = System.console().readLine();

							String sql = "DELETE FROM Has WHERE Member_ID = ? and Profile_Name = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1,input);
							pStmt.setString(2,input2);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Deleted");
							}
							pStmt.close();
							continue;					
						}
						
						if(input.equals("Watch")){
							System.out.println("Enter the Member_ID");
							input = System.console().readLine();
							System.out.println("Enter the Profile_Name");
							input2 = System.console().readLine();
							System.out.println("Enter the Movie_ID");
							input3 = System.console().readLine();
							
							String sql = "DELETE FROM Watch WHERE Member_ID = ? and Profile_Name = ? and Movie_ID = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1,input);
							pStmt.setString(2,input2);
							pStmt.setString(3,input3);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Deleted");
							}
							pStmt.close();
							continue;		
						}
						
						if(input.equals("Likes")){
							System.out.println("Enter the Member_ID");
							input = System.console().readLine();
							System.out.println("Enter the Profile_Name");
							input2 = System.console().readLine();
							System.out.println("Enter the m_genre");
							input3 = System.console().readLine();	

							String sql = "DELETE FROM Likes WHERE Member_ID = ? and Profile_Name = ? and m_genre = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1,input);
							pStmt.setString(2,input2);
							pStmt.setString(3,input3);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Deleted");
							}
							pStmt.close();
							continue;											
						}
						
						if(input.equals("Movie_Genre")){
							System.out.println("Enter the m_genre");
							input = System.console().readLine();
							System.out.println("Enter the Movie_ID");
							input2 = System.console().readLine();

							String sql = "DELETE FROM Movie_Genre WHERE m_genre = ? and Movie_ID = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1,input);
							pStmt.setString(2,input2);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Deleted");
							}
							pStmt.close();
							continue;									
						}
						
						if(input.equals("Starred_By")){
							System.out.println("Enter the Member_ID");
							input = System.console().readLine();
							System.out.println("Enter the Actor_ID");
							input2 = System.console().readLine();

							String sql = "DELETE FROM Starred_By WHERE Member_ID = ? and Actor_ID = ?";
							PreparedStatement pStmt = conn.prepareStatement(sql);
							pStmt.setString(1,input);
							pStmt.setString(2,input2);
							boolean checker = true;
							try{
								pStmt.executeUpdate();
							}	
							catch (SQLException sqle) {
								System.out.println("SQLException : " + sqle);
								checker = false;
							}
							if(checker){
								System.out.println("Record Deleted");
							}
							pStmt.close();
							continue;									
						}
						System.out.println("Invalid Input");
						continue;
					}
					System.out.println("Invalid Input");
					continue;
				}
				
				
				//Search Command
				if(input.equals("Search")){
					System.out.println("Enter Movie to search by movie name or Actor to search by actor");
					input = System.console().readLine();
					if(input.equals("Movie")){
						System.out.println("Enter movie name to search for");
						input = System.console().readLine();
						String sql = "SELECT * FROM Movie WHERE title = ?";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						pStmt.setString(1,input);
						ResultSet rset = pStmt.executeQuery();
						boolean bool = true;
						while (rset.next()){
							bool = false;
							System.out.println(rset.getString(1) + " " + rset.getString(2) + " " +rset.getInt(3) + " " +rset.getString(4) + " " + rset.getInt(5));
						}
						if(bool){
							System.out.println("no results found");
						}
						rset.close();
						pStmt.close();
						continue;
					}
					if(input.equals("Actor")){
						System.out.println("Enter first name of actor to search for");
						input = System.console().readLine();
						System.out.println("Enter last name of actor to search for");
						String input2 = System.console().readLine();
						String sql = "SELECT m.movie_ID, m.title, m.movie_year, m.producer, m.avg_rating FROM Movie m,Actor a,Starred_BY s WHERE a.first_name = ? and a.last_name = ? and a.actor_ID = s.actor_ID and s.movie_ID = m.movie_ID";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						pStmt.setString(1,input);
						pStmt.setString(2,input2);
						ResultSet rset = pStmt.executeQuery();
						boolean bool = true;
						while (rset.next()){
							bool = false;
							System.out.println(rset.getString(1) + " " + rset.getString(2) + " " +rset.getInt(3) + " " +rset.getString(4) + " " + rset.getInt(5));
						}
						if(bool){
							System.out.println("no results found");
						}
						rset.close();
						pStmt.close();
						continue;
					}
					System.out.println("Invalid Input");
					continue;
				}
				
				
				//Profile Rent History Command
				if(input.equals("Profile")){
					System.out.println("Enter the member_ID of the member containing the profile you are looking for");
					input = System.console().readLine();
					String sql = "SELECT member_ID FROM Member WHERE member_ID = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					pStmt.setString(1,input);
					ResultSet rset = pStmt.executeQuery();
					boolean bool = true;
					String memberid = null;
					while (rset.next()){
							bool = false;
							memberid = rset.getString(1);
					}
					if(bool){
						System.out.println("Member not found");
						rset.close();
						pStmt.close();
						continue;
					}
					System.out.println("Enter the name of the profile you are looking for");
					input = System.console().readLine();
					sql = "SELECT * FROM Watch WHERE member_ID = ? and profile_name = ?";
					pStmt = conn.prepareStatement(sql);
					pStmt.setString(1,memberid);
					pStmt.setString(2,input);
					rset = pStmt.executeQuery();
					bool = true;
					while (rset.next()){
							bool = false;
							System.out.println(rset.getString(1) + " " + rset.getString(2) + " " +rset.getString(3) + " " + rset.getInt(4));
					}
					if(bool){
						System.out.println("No results found");
						rset.close();
						pStmt.close();						
						continue;
					}
					rset.close();
					pStmt.close();					
					continue;
				}
				
				//Exit Command
				if(input.equals("Exit")){
					conn.close();
					break;
				}
				System.out.println("Invalid Command");
			}
		}
		catch (SQLException sqle) {
			System.out.println("SQLException : " + sqle);
		}
	}
}