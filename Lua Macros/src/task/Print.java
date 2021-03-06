package task;

class Print extends Task {

	@Override
	public String name() {
		return "debug";
	}

	@Override
	public void execute(String[] args, boolean fromKey) {
		if (args.length < 1) {
			return;
		}
		
		String message = "";
		
		for (int i = 0; i < args.length; i++) {
			if (i != 0)
				message += " ";
			
			message += args[i];
		}
		
		System.out.println(message);
	}

}
