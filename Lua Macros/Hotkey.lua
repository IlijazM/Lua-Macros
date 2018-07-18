args = {...}

keys = {}

local path = tostring(args[1])
local inpstr = tostring(args[2])

function getKeysstring()
	return tostring(args[3])
end

function getKey(i)
	if (string.sub(getKeysstring(), i + 1, i + 1) == "1") then
		return true
	else
		return false
	end
end

dofile "Keycode.lua"

local clock = os.clock
function sleep(n)
	n = n / 1000
    local t0 = clock()
    while clock() - t0 <= n do end
end

function stringlistener(string)
	
end

function keychanged()

end

function LeftClick()
	print "LeftClick"
end

function RightClick()
	print "RightClick"
end

function Click(a, b, c)
	if b == nil then
		print ("Click " .. tostring(a))
	elseif c == nil then
		print ("Click " .. tostring(a) .. " " .. tostring(b))
	else
		print ("Click " .. tostring(a) .. " " .. tostring(b) .. " " .. tostring(c))
	end
end

function MoveMouse(x, y)
	Click(0, x, y)
end

function WaitDef()
	-- sleep(0.01)
	print ("Wait")
end

function Wait(t)
	if t ~= nil then
		-- sleep(t)
		print ("Wait " .. t)
	else
		WaitDef()
	end
end

function WaitLong()
	-- sleep(0.1)
	print ("Wait Long")
end

function Debug()
	print "Debug"
end

function KeyType(k)
	if k ~= nil then
		print("KeyType " .. tostring(k))
	end
end

function KeyPress(k)
	if k ~= nil then
		print("KeyPress " .. tostring(k))
	end
end

function KeyRelease(k)
	if k ~= nil then
		print("KeyRelease " .. tostring(k))
	end
end

function Focus()
	print "Focus"
end

function Write(str)
	print("Write \"" .. str)
end

function DisableMacros()
	print "DisableMacros"
end

function EnableMacros()
	print "EnableMacros"
end

function Clear()
	print "Clear"
end

function ClearKey(i)
	print("Clear " .. tostring(i))
end

function Print(s)
	print("Debug " .. tostring(s))
end

function onlyOnce()
	return true
end

function Hotkey() end

if path ~= "" and path ~= nil then
	dofile(path)
	
	Hotkey()
	
	DisableMacros()
	
	if inpstr ~= "" and inpstr ~= nil then
		stringlistener(inpstr)
	else
		keychanged()
	end
	
	if onlyOnce() then
		Clear()
	end
end
