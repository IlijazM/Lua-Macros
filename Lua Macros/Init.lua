args = {...}

local path = tostring(args[1])

dofile "Keycode.lua"

function KeyCode(i)
	print("Keycode " .. i)
end

-- override
function Init() end

dofile(path)

Init()