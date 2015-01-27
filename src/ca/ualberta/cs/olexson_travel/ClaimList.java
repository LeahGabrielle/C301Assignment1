package ca.ualberta.cs.olexson_travel;

import java.util.ArrayList;

public class ClaimList {
	private ArrayList <Claim> claims;
	
	public ClaimList(){
		super();
	}

	public ClaimList(ArrayList<Claim> claims) {
		super();
		this.claims = claims;
	}
	
	public ArrayList<Claim> getClaims() {
		this.claims=new ArrayList<Claim>();
		return claims;
	}
	public void setClaims(ArrayList<Claim> claims) {
		this.claims = claims;
	}
	
	//Claims should be ordered by date (here?)
	//add a claim to the list of claims
	public ArrayList <Claim> addClaim(Claim claim){
		if (this.claims==null){
			this.claims= new ArrayList <Claim>();
		}
		this.claims.add(claim);
		notifylisteners();
		return this.claims;
	}
	private void notifylisteners() {
		//TODO	
	}

	//delete a claim from the list of claims
	public ArrayList<Claim> deleteClaim(Claim claim){
		this.claims.remove(claim);
		return this.claims;
	}
	public ArrayList<String> getClaimNames(){
		ArrayList<String> claimnames = new ArrayList<String>();
		for (Claim claim: this.claims){
			claimnames.add(claim.getName());
		}
		return claimnames;
	}
}
