args = {...}

local path = tostring(args[1])

dofile "Keycode.lua"

function KeyCode(i)
	print("Keycode " .. i)
end

function Control()
	KeyCode(CONTROL)
end

function Shift()
	KeyCode(SHIFT)
end

function Alt()
	KeyCode(ALT)
end

-- override
function Init() end

dofile(path)

Init()