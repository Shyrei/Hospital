package by.pvt.shyrei.hospital.command.factory;

import by.pvt.shyrei.hospital.command.ActionCommand;
import by.pvt.shyrei.hospital.command.admin.AddDoctorCommand;
import by.pvt.shyrei.hospital.command.admin.ShowDoctorCommand;
import by.pvt.shyrei.hospital.command.user.LoginUserCommand;
import by.pvt.shyrei.hospital.command.user.LogoutUserCommand;
import by.pvt.shyrei.hospital.command.user.RegisterUserCommand;
import by.pvt.shyrei.hospital.command.user.ShowDepartmentCommand;
import by.pvt.shyrei.hospital.command.user.ShowOneDepartmentCommand;
import by.pvt.shyrei.hospital.command.utils.ChangeLocaleCommand;
import by.pvt.shyrei.hospital.command.utils.GoToAddDoctorCommand;
import by.pvt.shyrei.hospital.command.utils.GoToMenuCommand;

/**
 * @author Shyrei Uladzimir
 * Enum of all command
 */
public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginUserCommand();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutUserCommand();
		}
	},
	REGISTER {
		{
			this.command = new RegisterUserCommand();
		}
	},
	
	ADD_DOCTOR {
		{
			this.command = new AddDoctorCommand();
		}
	},
	
	GO_TO_SHOW_DOCTOR {
		{
			this.command = new GoToAddDoctorCommand();
		}
	},
	GO_TO_MENU {
		{
			this.command = new GoToMenuCommand();
		}
	},
	CHANGE_LOCALE {
		{
			this.command = new ChangeLocaleCommand();
		}
	},
	SHOW_DEPARTMENTS {
		{
			this.command = new ShowDepartmentCommand();
		}
	},
	SHOW_ONE_DEPARTMENTS {
		{
			this.command = new ShowOneDepartmentCommand();
		}
	},
	SHOW_DOCTORS {
		{
			this.command = new ShowDoctorCommand();
		}
	};
	
	
	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}
	
