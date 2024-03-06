package com.diluna.lc.service;

import org.springframework.stereotype.Service;

//LCApp Logic
@Service
public class LCAppServiceImpl implements LCAppService {

	public final String LC_FORMULA="FLAME";
	
	@Override
	public String clculateLove(String username, String crushname) {
		int count=(username+crushname).toCharArray().length;
		int formular_count=LC_FORMULA.toCharArray().length;
		int rem= count %formular_count;
		char resultChar=LC_FORMULA.charAt(rem);
		String result= whatsBetweenUsre(resultChar);
		return result;
		
	}

	@Override
	public String whatsBetweenUsre(char calculateResult) {
		String result =null;
		if(calculateResult=='F'){
			return LoveCalcConstants.F_CHAR_MEANING;
		}
		else if(calculateResult=='L') {
			result = LoveCalcConstants.L_CHAR_MEANING;
			
		}
		else if(calculateResult=='A') {
			result = LoveCalcConstants.A_CHAR_MEANING;
			
		}
		else if(calculateResult=='M') {
			result = LoveCalcConstants.M_CHAR_MEANING;
			
		}
		else if(calculateResult=='E') {
			result = LoveCalcConstants.E_CHAR_MEANING;
			
		}
		return result;
	}

}
