package application;

public class MovieRating {
		private long userID;
		private long movieID;
		private double value; 
		/**
		 * @param userID
		 * @param movieID
		 * @param value
		 */
		public MovieRating(long uid, long mid, double v) {
			super();
			userID = uid;
			movieID = mid;
			value = v;
		}
		/**
		 * @return the user id
		 */
		public long getUserID() {
			return userID;
		}
		/**
		 * @param userid the id to set
		 */
		public void setUserId(long id) {
			userID = id;
		}
	        
	         /**
		 * @return the movie id
		 */
		public long getMovieID() {
			return movieID;
		}
		/**
		 * @param movieid the id to set
		 */
		public void setMovieId(long id) {
			movieID = id;
		}
		
		/**
		 * @return the value of the rating
		 */
		public double getValue() {
			return value;
		}
		 
		/**
		 * @param rate the value to set
		 */
		public void setValue(double rate) {
			value = rate;
		}
		
		@Override
		public String toString() {
			return "Rating [userID=" + userID + ", movieID=" + movieID + ", Value="+ value + "]";
		}
	}


