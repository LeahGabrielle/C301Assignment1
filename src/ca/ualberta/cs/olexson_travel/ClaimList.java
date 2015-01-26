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
	//add a claim to the list of claims
	public ArrayList <Claim> addClaim(Claim claim){
		if (this.claims==null){
			this.claims= new ArrayList <Claim>();
		}
		this.claims.add(claim);
		return this.claims;
	}
	//delete a claim from the list of claims
	public ArrayList<Claim> deleteClaim(Claim claim){
		this.claims.remove(claim);
		return this.claims;
	}
}
