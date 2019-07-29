package automationLib;

import java.io.IOException;

import utils.BaseLogger;
import utils.ErrorLogger;
import utils.SeleniumUtilities;

public class PreCondition {
	SeleniumUtilities utils = new SeleniumUtilities();
	BaseLogger blogger = new BaseLogger();

	
	
	/**Select Interaction, search for a member, select first member from list and submit then select first contract displayed and navigate to task mentioned*/
	public boolean navigateToTaskFunctionalities(String[] args) throws InterruptedException {
		ErrorLogger err = new ErrorLogger();
		Boolean flag = false;

		try {
			LogIn lg = new LogIn();
			lg.logIn();

			String values = args[0].replaceAll("<", "").replaceAll(">", "");
			String[] value = values.split(";");

			/**Select Interaction*/
			Header hr = new Header();
			if(value[0].equalsIgnoreCase("Research")) {
				if(hr.createNewInteractionResearchmember()) {
					ResearchMember rm = new ResearchMember();
					flag = rm.searchAndSubmitMember(value);
					
				}

			}else if(value[0].equalsIgnoreCase("Phone")){
				if(hr.createNewInteractionPhoneCallmember()) {
					PhoneCallMembersearchMember phcall = new PhoneCallMembersearchMember();
					flag = phcall.searchAndSubmitPhoneMember(value);
				
				}

			}else if(value[0].equalsIgnoreCase("Chat")){
				if(hr.createNewInteractionChatmember()) {
					ChatMember cm = new ChatMember();
					flag = cm.searchAndSubmitChatMember(value);
					
				}

			}else if(value[0].equalsIgnoreCase("Secure Message")){
				if(hr.createNewInteractionSecureMessageMember()) {
					SecureMessageMember_SearchMember cm = new SecureMessageMember_SearchMember();
					flag = cm.searchAndSubmitSecureMember(value);
				
				}
			}

			if(!flag) {
				err.logError("Failed while Launching an Interaction");
				return false;
			}

			/**This method is to select contract*/
			if(value[0].equalsIgnoreCase("Phone")) {
			SelectContract sc = new SelectContract();
			flag = sc.selectContractInSearchMember(value);
			}else {
				SelectContract sc = new SelectContract();
				flag = sc.selectContract(value);
			}
			//flag =sc.selectfirstContract();

			if(!flag) {
				err.logError("Failed while selecting a contract");
				return false;
			}

		/*	if(value[0].equalsIgnoreCase("Chat")) {
				VerifyMember vm = new VerifyMember();
				flag  = vm.verifyMemberDetailsWithoutData();
			}*/

			if(!flag) {
				err.logError("Failed in Member verification Page");
				return false;
			}

			/**This method is to navigate to corresponding Task*/
			MemberComposite mc = new MemberComposite();
			flag = mc.navigateToTask(value[1]);

			if(!flag) {
				err.logError("Failed in Navigating to task functionalities");
				return false;
			}


			return true;

		}catch(Exception e) {
			err.logError("Failed due to "+e);
			return false;
		}

	}

	/**Select Interaction, search for a member, select first member from list and submit then select first contract displayed and Select tab in Member Composite Page*/
	public boolean navigateToMemberCompositeTabFunctionalities(String[] args) throws InterruptedException {
		ErrorLogger err = new ErrorLogger();

		try {
			LogIn lg = new LogIn();
			lg.logIn();

			String values = args[0].replaceAll("<", "").replaceAll(">", "");
			String[] value = values.split(";");

			/**Select Interaction*/
			Header hr = new Header();
			if(value[0].equalsIgnoreCase("Research")) {
				hr.createNewInteractionResearchmember();
				ResearchMember rm = new ResearchMember();
				rm.searchAndSubmitMember(value);

			}else if(value[0].equalsIgnoreCase("Phone")){
				hr.createNewInteractionPhoneCallmember();
				PhoneCallMembersearchMember phcall = new PhoneCallMembersearchMember();
				phcall.searchAndSubmitPhoneMember(value);

			}else if(value[0].equalsIgnoreCase("Chat")){
				hr.createNewInteractionChatmember();
				ChatMember cm = new ChatMember();
				cm.searchAndSubmitChatMember(value);

			}else if(value[0].equalsIgnoreCase("Secure Message")){
				hr.createNewInteractionSecureMessageMember();
				SecureMessageMember_SearchMember cm = new SecureMessageMember_SearchMember();
				cm.searchAndSubmitSecureMember(value);
				
			}else if(value[0].equalsIgnoreCase("Email")){
				hr.createNewInteractionEmailMember();
				EmailInteraction_SearchMember cm = new EmailInteraction_SearchMember();
				cm.searchAndSubmitEmailMember(value);
				
			}else if(value[0].equalsIgnoreCase("Outbound Call")){
				hr.createNewInteractionOutboundcall();
				OutboundCall_SearchMember cm = new OutboundCall_SearchMember();
				cm.searchAndSubmitOutboundMember(value);
			}

			/**This method is to select contract*/
			if(value[0].equalsIgnoreCase("Phone")) {
				SelectContract sc = new SelectContract();
				 sc.selectContractInSearchMember(value);
				}else {
					SelectContract sc = new SelectContract();
					 sc.selectContract(value);
				}

			if( value[0].equalsIgnoreCase("Chat")) {
				VerifyMember vm = new VerifyMember();
				vm.verifyMemberDetailsWithoutData();
			}

			return true;

		}catch(Exception e) {
			err.logError("Failed due to "+e);
			return false;
		}
	}

	/**Select Interaction, search for a NPI, select first member from list and submit then select first contract displayed and Select tab in Member Composite Page*/
	public boolean navigateToTaskFunctionalitiesForProviderFlow(String[] args) throws InterruptedException {
		ErrorLogger err = new ErrorLogger();
		try {
			LogIn lg = new LogIn();
			lg.logIn();

			String values = args[0].replaceAll("<", "").replaceAll(">", "");
			String[] value = values.split(";");

			/**Select Interaction*/
			Header hr = new Header();
			if(value[0].equalsIgnoreCase("Research")) {
				hr.createNewInteractionResearchProvider();
				ResearchProvider rp = new ResearchProvider();
				rp.searchAndSubmitProvider(value);

			}else if(value[0].equalsIgnoreCase("Phone")){
				hr.createNewInteractionPhoneCallprovider();
				PhoneCallprovider phcall = new PhoneCallprovider();
				phcall.searchAndSubmitProvider(value);

			}
			if(!utils.isServiceDown()) {
				
				if(value[0].equalsIgnoreCase("Phone")) {
					ResearchMember rm = new ResearchMember();
					rm.searchAndSubmitMemberForPhonecallProvider(value);
					SelectContract sc = new SelectContract();
					 sc.selectContractInSearchMember(value);
					}else {
						ResearchMember rm = new ResearchMember();
						rm.searchAndSubmitMember(value);
						SelectContract sc = new SelectContract();
						 sc.selectContract(value);
					}

				MemberComposite mc = new MemberComposite();
				mc.navigateToTask(value[3]);

				return true;
			}else {
				return false;
			}

		}catch(Exception e) {
			err.logError("Failed due to "+e);
			return false;
		}
	}

	/**Select Interaction, search for a NPI, select first member from list and submit then select first contract displayed and Select tab in Member Composite Page*/
	public boolean navigateToProviderCompositeTabFunctionalities(String[] args) throws InterruptedException {
		ErrorLogger err = new ErrorLogger();
		try {
			LogIn lg = new LogIn();
			lg.logIn();

			String values = args[0].replaceAll("<", "").replaceAll(">", "");
			String[] value = values.split(";");

			/**Select Interaction*/
			Header hr = new Header();
			if(value[0].equalsIgnoreCase("Research")) {
				hr.createNewInteractionResearchProvider();
				ResearchProvider rp = new ResearchProvider();
				rp.searchAndSubmitProvider(value);

			}else if(value[0].equalsIgnoreCase("Phone")){
				hr.createNewInteractionPhoneCallprovider();
				PhoneCallprovider phcall = new PhoneCallprovider();
				phcall.searchAndSubmitProvider(value);

			}

			if(!utils.isServiceDown()) {

				
				if(value[0].equalsIgnoreCase("Phone")) {
					ResearchMember rm = new ResearchMember();
					rm.searchAndSubmitMemberForPhonecallProvider(value);
					SelectContract sc = new SelectContract();
					 sc.selectContractInSearchMember(value);
					}else {
						ResearchMember rm = new ResearchMember();
						rm.searchAndSubmitMember(value);
						SelectContract sc = new SelectContract();
						 sc.selectContract(value);
					}

				return true;
			}else {
				return false;
			}

		}catch(Exception e) {
			err.logError("Failed due to "+e);
			return false;
		}
	}
	
	public boolean navigateToBrokerCompositeTabFunctionalitiesForBrokerTINFlow(String[] args) throws InterruptedException {
		ErrorLogger err = new ErrorLogger();

		try {
			LogIn lg = new LogIn();
			lg.logIn();

			String values = args[0].replaceAll("<", "").replaceAll(">", "");
			String[] value = values.split(";");
			
			Header hr = new Header();
			if(value[0].equalsIgnoreCase("Research")) {
				hr.createNewInteractionResearchBroker();	
				BrokerResearchInteraction rs = new BrokerResearchInteraction();
				rs.searchForBrokerUsingTINFlowForResearchInteraction(value);
				ResearchMember rm = new ResearchMember();	
				rm.searchAndSubmitMember(value);

			}else if(value[0].equalsIgnoreCase("Phone")){
				hr.createNewInteractionPhoneCallBroker();
				
				PhoneCallBrokersearchBroker phcall = new PhoneCallBrokersearchBroker();
				phcall.searchForBrokerUsingTINFlowForPhoneCallInteraction(value);
				PhoneCallMembersearchMember phcall1 = new PhoneCallMembersearchMember();
				phcall1.searchAndSubmitPhoneMemberForBrokerFlow(value);

			}
			
			else if(value[0].equalsIgnoreCase("Email")){
				hr.createNewInteractionEmailBroker();
				
				BrokerEmailInteraction phcall = new BrokerEmailInteraction();
				phcall.searchForBrokerUsingTINFlowForEmailInteraction(value);
				EmailInteraction_SearchMember phcall1 = new EmailInteraction_SearchMember();
				phcall1.searchAndSubmitEmailMemberForBrokerFlow(value);	
			}

			SelectContract sc = new SelectContract();
			sc.selectContract(value);

			if(value[0].equalsIgnoreCase("Phone") || value[0].equalsIgnoreCase("Chat")) {
				VerifyMember vm = new VerifyMember();
				vm.verifyMemberDetailsWithoutData();
			
			}
			
			return true;
			
			/*MemberComposite mc = new MemberComposite();
			mc.navigateToTask(value[3]);
			Thread.sleep(3000);
			return true;*/

		}catch(Exception e) {
			err.logError("Failed due to "+e);
			return false;
		}

	}
	
	
	public boolean navigateToBrokerCompositeTabFunctionalitiesForBrokerTINFlowWithMemberNotInFocus(String[] args) throws InterruptedException {
		ErrorLogger err = new ErrorLogger();

		try {
			LogIn lg = new LogIn();
			lg.logIn();

			String values = args[0].replaceAll("<", "").replaceAll(">", "");
			String[] value = values.split(";");
			
			Header hr = new Header();
			if(value[0].equalsIgnoreCase("Research")) {
				hr.createNewInteractionResearchBroker();	
				BrokerResearchInteraction rs = new BrokerResearchInteraction();
				rs.searchForBrokerUsingTINFlowForResearchInteractionWithMemberNotInFocus(value);
				/*ResearchMember rm = new ResearchMember();	
				rm.searchAndSubmitMember(value);*/

			}else if(value[0].equalsIgnoreCase("Phone")){
				hr.createNewInteractionPhoneCallBroker();
				PhoneCallBrokersearchBroker phcall = new PhoneCallBrokersearchBroker();
				phcall.searchForBrokerUsingTINFlowForPhoneCallInteractionWithMemberNotInFocus(value);
				/*PhoneCallMembersearchMember phcall1 = new PhoneCallMembersearchMember();
				phcall1.searchAndSubmitPhoneMemberForBrokerFlow(value);*/

			}
			
			else if(value[0].equalsIgnoreCase("Email")){
				hr.createNewInteractionEmailBroker();
				
				BrokerEmailInteraction phcall = new BrokerEmailInteraction();
				phcall.searchForBrokerUsingTINFlowForEmailInteractionWithMemberNotInFocus(value);
				/*EmailInteraction_SearchMember phcall1 = new EmailInteraction_SearchMember();
				phcall1.searchAndSubmitEmailMemberForBrokerFlow(value);	*/
			}

			/*SelectContract sc = new SelectContract();
			sc.selectContract(value);

			if(value[0].equalsIgnoreCase("Phone") || value[0].equalsIgnoreCase("Chat")) {
				VerifyMember vm = new VerifyMember();
				vm.verifyMemberDetailsWithoutData();
			
			}*/
			
			return true;
			
			/*MemberComposite mc = new MemberComposite();
			mc.navigateToTask(value[3]);
			Thread.sleep(3000);
			return true;*/

		}catch(Exception e) {
			err.logError("Failed due to "+e);
			return false;
		}

	}
	

	
	public boolean navigateToTaskFunctionalitiesForBrokerTINFlow(String[] args) throws InterruptedException {
		ErrorLogger err = new ErrorLogger();

		try {
			LogIn lg = new LogIn();
			lg.logIn();

			String values = args[0].replaceAll("<", "").replaceAll(">", "");
			String[] value = values.split(";");
			
			Header hr = new Header();
			if(value[0].equalsIgnoreCase("Research")) {
				hr.createNewInteractionResearchBroker();	
				BrokerResearchInteraction rs = new BrokerResearchInteraction();
				rs.searchForBrokerUsingTINFlowForResearchInteraction(value);
				ResearchMember rm = new ResearchMember();	
				rm.searchAndSubmitMember(value);

			}else if(value[0].equalsIgnoreCase("Phone")){
				hr.createNewInteractionPhoneCallBroker();
				
				PhoneCallBrokersearchBroker phcall = new PhoneCallBrokersearchBroker();
				phcall.searchForBrokerUsingTINFlowForPhoneCallInteraction(value);
				PhoneCallMembersearchMember phcall1 = new PhoneCallMembersearchMember();
				phcall1.searchAndSubmitPhoneMemberForBrokerFlow(value);

			}
			
			else if(value[0].equalsIgnoreCase("Email")){
				hr.createNewInteractionEmailBroker();
				
				BrokerEmailInteraction phcall = new BrokerEmailInteraction();
				phcall.searchForBrokerUsingTINFlowForEmailInteraction(value);
				EmailInteraction_SearchMember phcall1 = new EmailInteraction_SearchMember();
				phcall1.searchAndSubmitEmailMemberForBrokerFlow(value);	
			}

			Thread.sleep(3000);
			SelectContract sc = new SelectContract();
			sc.selectContract(value);

			if(value[0].equalsIgnoreCase("Phone") || value[0].equalsIgnoreCase("Chat")) {
				VerifyMember vm = new VerifyMember();
				vm.verifyMemberDetailsWithoutData();
			}
			
			MemberComposite mc = new MemberComposite();
			mc.navigateToTask(value[3]);
			Thread.sleep(3000);
			return true;

		}catch(Exception e) {
			err.logError("Failed due to "+e);
			return false;
		}

	}
	
	
	public boolean navigateToTaskFunctionalitiesForBrokerTINFlowWithMemberNotInFocus(String[] args) throws InterruptedException {
		ErrorLogger err = new ErrorLogger();

		try {
			LogIn lg = new LogIn();
			lg.logIn();

			String values = args[0].replaceAll("<", "").replaceAll(">", "");
			String[] value = values.split(";");
			
			Header hr = new Header();
			if(value[0].equalsIgnoreCase("Research")) {
				hr.createNewInteractionResearchBroker();	
				BrokerResearchInteraction rs = new BrokerResearchInteraction();
				rs.searchForBrokerUsingTINFlowForResearchInteractionWithMemberNotInFocus(value);
				/*ResearchMember rm = new ResearchMember();	
				rm.searchAndSubmitMember(value);*/

			}else if(value[0].equalsIgnoreCase("Phone")){
				hr.createNewInteractionPhoneCallBroker();
				
				PhoneCallBrokersearchBroker phcall = new PhoneCallBrokersearchBroker();
				phcall.searchForBrokerUsingTINFlowForPhoneCallInteractionWithMemberNotInFocus(value);
				/*PhoneCallMembersearchMember phcall1 = new PhoneCallMembersearchMember();
				phcall1.searchAndSubmitPhoneMemberForBrokerFlow(value);*/

			}
			
			else if(value[0].equalsIgnoreCase("Email")){
				hr.createNewInteractionEmailBroker();
				
				BrokerEmailInteraction phcall = new BrokerEmailInteraction();
				phcall.searchForBrokerUsingTINFlowForEmailInteractionWithMemberNotInFocus(value);
				/*EmailInteraction_SearchMember phcall1 = new EmailInteraction_SearchMember();
				phcall1.searchAndSubmitEmailMemberForBrokerFlow(value);	*/
			}

			Thread.sleep(3000);
			/*SelectContract sc = new SelectContract();
			sc.selectContract(value);

			if(value[0].equalsIgnoreCase("Phone") || value[0].equalsIgnoreCase("Chat")) {
				VerifyMember vm = new VerifyMember();
				vm.verifyMemberDetailsWithoutData();
			}*/
			
			MemberComposite mc = new MemberComposite();
			mc.navigateToTask(value[2]);
			Thread.sleep(3000);
			return true;

		}catch(Exception e) {
			err.logError("Failed due to "+e);
			return false;
		}

	}


	
	public boolean navigateToTaskFunctionalitiesForBrokerGroupAdminFlow(String[] args) throws InterruptedException {
		ErrorLogger err = new ErrorLogger();

		try {
			LogIn lg = new LogIn();
			lg.logIn();

			String values = args[0].replaceAll("<", "").replaceAll(">", "");
			String[] value = values.split(";");

			Header hr = new Header();
			if(value[0].equalsIgnoreCase("Research")) {
				hr.createNewInteractionResearchBroker();	
				BrokerResearchInteraction rs = new BrokerResearchInteraction();
				rs.searchForBrokerUsingGroupAdminFlowForResearchInteraction(value);
				ResearchMember rm = new ResearchMember();	
				rm.searchAndSubmitMember(value);

			}else if(value[0].equalsIgnoreCase("Phone")){
				hr.createNewInteractionPhoneCallBroker();	
				PhoneCallBrokersearchBroker phcall = new PhoneCallBrokersearchBroker();
				phcall.searchForBrokerUsingGroupAdminFlowForPhoneCallInteraction(value);
				PhoneCallMembersearchMember phcall1 = new PhoneCallMembersearchMember();
				phcall1.searchAndSubmitPhoneMemberForBrokerFlow(value);

			}
			
			else if(value[0].equalsIgnoreCase("Email")){
				hr.createNewInteractionEmailBroker();
				BrokerEmailInteraction phcall = new BrokerEmailInteraction();
				phcall.searchForBrokerUsingGroupAdminFlowForEmailInteraction(value);
				EmailInteraction_SearchMember phcall1 = new EmailInteraction_SearchMember();
				phcall1.searchAndSubmitEmailMemberForBrokerFlow(value);	
			}

			SelectContract sc = new SelectContract();
			sc.selectContract(value);

			if(value[0].equalsIgnoreCase("Phone") || value[0].equalsIgnoreCase("Chat")) {
				VerifyMember vm = new VerifyMember();
				vm.verifyMemberDetailsWithoutData();
			}

			/**This method is to navigate to corresponding Task*/
			MemberComposite mc = new MemberComposite();
			mc.navigateToTask(value[3]);
			Thread.sleep(3000);
			return true;

		}catch(Exception e) {
			err.logError("Failed due to "+e);
			return false;
		}

	}
	
	

	public boolean navigateToTaskFunctionalitiesForBrokerGroupAdminFlowWithMemebrNotInFocus(String[] args) throws InterruptedException {
		ErrorLogger err = new ErrorLogger();

		try {
			LogIn lg = new LogIn();
			lg.logIn();

			String values = args[0].replaceAll("<", "").replaceAll(">", "");
			String[] value = values.split(";");

			Header hr = new Header();
			if(value[0].equalsIgnoreCase("Research")) {
				hr.createNewInteractionResearchBroker();	
				BrokerResearchInteraction rs = new BrokerResearchInteraction();
				rs.searchForBrokerUsingGroupAdminFlowForResearchInteractionWithMemberNotInFocus(value);
				/*ResearchMember rm = new ResearchMember();	
				rm.searchAndSubmitMember(value);*/

			}else if(value[0].equalsIgnoreCase("Phone")){
				hr.createNewInteractionPhoneCallBroker();	
				PhoneCallBrokersearchBroker phcall = new PhoneCallBrokersearchBroker();
				phcall.searchForBrokerUsingGroupAdminFlowForPhoneCallInteractionWithMemberNotInFocus(value);
				/*PhoneCallMembersearchMember phcall1 = new PhoneCallMembersearchMember();
				phcall1.searchAndSubmitPhoneMemberForBrokerFlow(value);*/

			}
			
			else if(value[0].equalsIgnoreCase("Email")){
				hr.createNewInteractionEmailBroker();
				BrokerEmailInteraction phcall = new BrokerEmailInteraction();
				phcall.searchForBrokerUsingGroupAdminFlowForEmailInteractionWithMemberNotInFocus(value);
				/*EmailInteraction_SearchMember phcall1 = new EmailInteraction_SearchMember();
				phcall1.searchAndSubmitEmailMemberForBrokerFlow(value);	*/
			}

			/*SelectContract sc = new SelectContract();
			sc.selectContract(value);

			if(value[0].equalsIgnoreCase("Phone") || value[0].equalsIgnoreCase("Chat")) {
				VerifyMember vm = new VerifyMember();
				vm.verifyMemberDetailsWithoutData();
			}*/

			/**This method is to navigate to corresponding Task*/
			MemberComposite mc = new MemberComposite();
			mc.navigateToTask(value[2]);
			Thread.sleep(3000);
			return true;

		}catch(Exception e) {
			err.logError("Failed due to "+e);
			return false;
		}

	}

	
	
	public boolean navigateToBrokerCompositeTabFunctionalitiesForBrokerGroupAdminFlow(String[] args) throws InterruptedException {
		ErrorLogger err = new ErrorLogger();

		try {
			LogIn lg = new LogIn();
			lg.logIn();

			String values = args[0].replaceAll("<", "").replaceAll(">", "");
			String[] value = values.split(";");

			Header hr = new Header();
			if(value[0].equalsIgnoreCase("Research")) {
				hr.createNewInteractionResearchBroker();	
				BrokerResearchInteraction rs = new BrokerResearchInteraction();
				rs.searchForBrokerUsingGroupAdminFlowForResearchInteraction(value);
				ResearchMember rm = new ResearchMember();	
				rm.searchAndSubmitMember(value);

			}else if(value[0].equalsIgnoreCase("Phone")){
				hr.createNewInteractionPhoneCallBroker();
				
				PhoneCallBrokersearchBroker phcall = new PhoneCallBrokersearchBroker();
				phcall.searchForBrokerUsingGroupAdminFlowForPhoneCallInteraction(value);
				PhoneCallMembersearchMember phcall1 = new PhoneCallMembersearchMember();
				phcall1.searchAndSubmitPhoneMemberForBrokerFlow(value);

			}
			
			else if(value[0].equalsIgnoreCase("Email")){
				hr.createNewInteractionEmailBroker();
				
				BrokerEmailInteraction phcall = new BrokerEmailInteraction();
				phcall.searchForBrokerUsingGroupAdminFlowForEmailInteraction(value);
				EmailInteraction_SearchMember phcall1 = new EmailInteraction_SearchMember();
				phcall1.searchAndSubmitEmailMemberForBrokerFlow(value);	
			}

			SelectContract sc = new SelectContract();
			sc.selectContract(value);

			if(value[0].equalsIgnoreCase("Phone") || value[0].equalsIgnoreCase("Chat")) {
				VerifyMember vm = new VerifyMember();
				vm.verifyMemberDetailsWithoutData();
				
			}
			
			return true;

			/*
			/**This method is to navigate to corresponding Task*/
			/*MemberComposite mc = new MemberComposite();
			mc.navigateToTask(value[3]);
			Thread.sleep(3000);
			return true;*/


		}catch(Exception e) {
			err.logError("Failed due to "+e);
			return false;
		}
		//return false;

	}
	
	
	
	public boolean navigateToBrokerCompositeTabFunctionalitiesForBrokerGroupAdminFlowForMemberNotInFocus(String[] args) throws InterruptedException {
		ErrorLogger err = new ErrorLogger();

		try {
			LogIn lg = new LogIn();
			lg.logIn();

			String values = args[0].replaceAll("<", "").replaceAll(">", "");
			String[] value = values.split(";");

			Header hr = new Header();
			if(value[0].equalsIgnoreCase("Research")) {
				hr.createNewInteractionResearchBroker();	
				BrokerResearchInteraction rs = new BrokerResearchInteraction();
				rs.searchForBrokerUsingGroupAdminFlowForResearchInteractionWithMemberNotInFocus(value);
				/*ResearchMember rm = new ResearchMember();	
				rm.searchAndSubmitMember(value);*/

			}else if(value[0].equalsIgnoreCase("Phone")){
				hr.createNewInteractionPhoneCallBroker();
				
				PhoneCallBrokersearchBroker phcall = new PhoneCallBrokersearchBroker();
				phcall.searchForBrokerUsingGroupAdminFlowForPhoneCallInteractionWithMemberNotInFocus(value);
				/*PhoneCallMembersearchMember phcall1 = new PhoneCallMembersearchMember();
				phcall1.searchAndSubmitPhoneMemberForBrokerFlow(value);*/

			}
			
			else if(value[0].equalsIgnoreCase("Email")){
				hr.createNewInteractionEmailBroker();
				
				BrokerEmailInteraction phcall = new BrokerEmailInteraction();
				phcall.searchForBrokerUsingGroupAdminFlowForEmailInteractionWithMemberNotInFocus(value);
				/*EmailInteraction_SearchMember phcall1 = new EmailInteraction_SearchMember();
				phcall1.searchAndSubmitEmailMemberForBrokerFlow(value);	*/
			}

			/*SelectContract sc = new SelectContract();
			sc.selectContract(value);

			if(value[0].equalsIgnoreCase("Phone") || value[0].equalsIgnoreCase("Chat")) {
				VerifyMember vm = new VerifyMember();
				vm.verifyMemberDetailsWithoutData();
				
			}*/
			
			return true;

			/*
			/**This method is to navigate to corresponding Task*/
			/*MemberComposite mc = new MemberComposite();
			mc.navigateToTask(value[3]);
			Thread.sleep(3000);
			return true;*/


		}catch(Exception e) {
			err.logError("Failed due to "+e);
			return false;
		}
		//return false;

	}


	/*public boolean navigateToTaskFunctionalitiesForBroker(String[] args) throws InterruptedException, IOException {
		ErrorLogger err = new ErrorLogger();
			LogIn lg = new LogIn();
			lg.logIn();

			String values = args[0].replaceAll("<", "").replaceAll(">", "");
			String[] value = values.split(";");

			Header hr = new Header();
			if(value[0].equalsIgnoreCase("Research")) {
				hr.createNewInteractionResearchBroker();
				ResearchMember rm = new ResearchMember();
				rm.searchAndSubmitMember(value);

			}else if(value[0].equalsIgnoreCase("Phone")){
				hr.createNewInteractionPhoneCallmember();
				PhoneCallMembersearchMember phcall = new PhoneCallMembersearchMember();
				phcall.searchAndSubmitPhoneMember(value);

			}else if(value[0].equalsIgnoreCase("Chat")){
				hr.createNewInteractionChatmember();
				ChatMember cm = new ChatMember();
				cm.searchAndSubmitChatMember(value);

			}else if(value[0].equalsIgnoreCase("Secure Message")){
				hr.createNewInteractionSecureMessageMember();
				SecureMessageMember_SearchMember cm = new SecureMessageMember_SearchMember();
				cm.searchAndSubmitSecureMember(value);
			}
			return false;

}*/
}
