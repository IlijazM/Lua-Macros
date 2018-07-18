function Init()
	KeyCode(U)
end

function Hotkey()
	KeyPress(DELETE)
	
	for i = 1, 10 do
		Wait()
		Write("Was laberscht du?")
		WaitLong()
		KeyPress(RETURN)
	end
end