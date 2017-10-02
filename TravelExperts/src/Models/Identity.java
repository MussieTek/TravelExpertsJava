package Models;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Random;
import java.util.Base64; 

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class Identity {
	
	int agentId; 
	byte[] salt;
	// Password is an MD5 Hash, not a plain text.
	String username, pwdHash;
	
	// Constructor for new Identity. Password is a 
	// plain text password in this instance, and will be encrypted 
	public Identity(int agentId, String username, String password) {
		super();
		this.agentId = agentId;
		this.username = username;
		try {
			this.pwdHash = encrypt(password, null);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// Constructor for existing identity. Password should be hashed password value
	public Identity(int agentId, byte[] salt, String username, String pwdHash) {
		super();
		this.agentId = agentId;
		this.salt = salt;
		this.username = username;
		this.pwdHash = pwdHash;
	}

// ----------------GETTERS AND SETTERS ---------------------

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return pwdHash;
	}

	public void setPassword(String password) {
		this.pwdHash = password;
	}
	
	
//--------------------FUNCTIONS ---------------------
	
	public Boolean verify(String testPass) {
		try {
			String testHash = encrypt(testPass, this.salt);
			
			// -----------DEBUG---------
//			System.out.println("verify: " + testHash);
//			System.out.println("Old:    " + this.pwdHash);
			
			if (testHash.equals(this.pwdHash)) return true;
			else return false;
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	//  If Salt is Null, encrypt will get and set a new random salt. Otherwise, encrypt
	// will generate a 64 bit password hash with the user's existing salt. 
	public String encrypt(String txtPassword, byte[] salt ) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// For null salts or new passwords
		if (salt == null) {
			salt = new byte[8];
			Random rand = new Random();
			rand.nextBytes(salt);
			this.salt = salt; 
			//IdentityDB.setSalt(this.agentId, salt);
		}
		
		KeySpec spec = new PBEKeySpec(txtPassword.toCharArray(), salt, 65536, 64);
		SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] hash = f.generateSecret(spec).getEncoded();
		Base64.Encoder enc = Base64.getEncoder();
		// --------DEBUG--------
		//System.out.printf("salt: %s", enc.encodeToString(salt));
		//System.out.printf("hash: %s", enc.encodeToString(hash));
		
		return enc.encodeToString(hash);
	}
	
	public boolean changePassword(String oldPassword, String newPassword) {
		String newPwdHash;
		System.out.println(this.pwdHash);
		
		// If the user has no password, set the user's password 
		if(this.pwdHash.equals("")) {
			try {	
				newPwdHash = encrypt(newPassword, null);
				this.pwdHash = newPwdHash;
				// Update the database with new values 
				IdentityDB.setSalt(this.agentId, this.salt);
				IdentityDB.setPassword(this.agentId, this.pwdHash);
				return true; 
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		// Otherwise, verify the old password and change to the new password 
		if (verify(oldPassword)) {
			try {
				// Get new hash and fresh salt
				newPwdHash = encrypt(newPassword, null);
				this.pwdHash = newPwdHash;
				// Update the database with new values 
				IdentityDB.setSalt(this.agentId, this.salt);
				IdentityDB.setPassword(this.agentId, this.pwdHash);
				return true; 
				
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// If the old password is incorrect, return False.
		return false;
		
	}
	
	

}
