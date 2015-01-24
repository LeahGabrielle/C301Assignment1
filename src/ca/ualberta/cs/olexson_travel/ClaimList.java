package ca.ualberta.cs.olexson_travel;

import java.util.ArrayList;

public class ClaimList {
	public ArrayList <Claim> claims;
	//add claim to claims
	//delete claim from claims

	public ClaimList(ArrayList<Claim> claims) {
		super();
		this.claims = claims;
	}
	public ClaimList(){
		super();
	}
	//Claims should be ordered by date (here?)
	public ArrayList <Claim> addClaim(Claim claim){
		this.claims.add(claim);
		return this.claims;
	}
	public ArrayList<Claim> deleteClaim(Claim claim){
		
		return this.claims;
	}
}
