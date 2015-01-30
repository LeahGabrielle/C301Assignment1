package ca.ualberta.cs.olexson_travel;

import java.io.Serializable;
import java.util.ArrayList;

public class ClaimList  implements Serializable{
	
	private static final long serialVersionUID = 6673446047991058932L;
	protected ArrayList <Claim> claims = null;
	protected transient ArrayList<Listener> listeners = null;
	
	public ClaimList(){
		super();
		claims= new ArrayList<Claim>();
		listeners = new ArrayList<Listener>();
	}

	public ClaimList(ArrayList<Claim> claims) {
		super();
		this.claims = claims;
		listeners = new ArrayList<Listener>();
	}
	
	public ArrayList<Claim> getClaims() {
		//this.claims=new ArrayList<Claim>();
		return claims;
	}
	public void setClaims(ArrayList<Claim> claims) {
		this.claims = claims;
	}
	
	private ArrayList<Listener> getListeners(){
		if (listeners==null){
			listeners = new ArrayList<Listener>();
		}
		return listeners;
	}
	
	//Claims should be ordered by date (here?)
	//add a claim to the list of claims
	public void addClaim(Claim claim){
		this.claims.add(claim);
		notifyListeners();
	}
	private void notifyListeners() {
		for (Listener listener:getListeners()){
			listener.update();
		}
	}

	//delete a claim from the list of claims
	public ArrayList<Claim> deleteClaim(Claim claim){
		this.claims.remove(claim);
		notifyListeners();
		return this.claims;
	}
	
	public void addListener(Listener l){
		getListeners().add(l);
	}
	
	public void removeListener(Listener l){
		getListeners().remove(l);
	}
	
	
}
