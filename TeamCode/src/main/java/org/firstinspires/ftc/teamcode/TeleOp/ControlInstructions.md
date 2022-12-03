# CONTROL INSTRUCTIONS

### DriveTrain
- Left Joystick:
  -> Up, Down => Forward, Back
  -> Left, Right => Strafe Left, Strafe Right
- Right Joystick
  -> Left, Right => Turn Anti-Clockwise

### Gripper Subsystem
- On Initialize
  -> Gripper is grounded
- Press and Hold 'A' button
  -> Gripper raises up
  -> Gripper closes if it didn't already
  -> Move the bot forward to prepare for next step
- Release 'A' Button
  -> Gripper closes if it wasn't already closed
  -> Gripper drops down
  -> Gripper opens to secure cone
  -> Gripper moves up
- Tap 'A' once
  -> Gripper goes to the height of the small pole
  -> Gripper stays closed 
- Tap 'A' a second time
  -> Gripper goes to the height of a medium pole
  -> Gripper stays closed 
- Tap 'Right Bumper' once
  -> Gripper closes; Cone drops
  -> Gripper resets to 'On Initialize'. 