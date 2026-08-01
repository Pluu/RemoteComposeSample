# Interactivity, Positioning, and Profiles

## RcActionScope

Used within event modifiers like `onClick` to define what happens when a user interacts with a component.

- `setValue(variable, value)`: Sets a remote variable (`RcFloat`, `RcInteger`, `RcText`, `RcBool`) to a literal or expression.
- `hostAction(name)`: Triggers a named action handled by the platform host.

## Positioning

`RcPositioning` defines how children are aligned within a layout.

### Horizontal Positioning
- `Start`, `Center`, `End`.
- `SpaceBetween`, `SpaceEvenly`, `SpaceAround` (for Rows).

### Vertical Positioning
- `Top`, `Center`, `Bottom`.
- `SpaceBetween`, `SpaceEvenly`, `SpaceAround` (for Columns).

## RcProfile

Encapsulates the configuration and capabilities of a RemoteCompose document.

- `profile`: Underlying API level and operation bitmasks.
- `experimental`: Flag for experimental operations.
- `platform`: Access to platform services.

## Haptics

`performHaptic(RcHaptic)` can be used to trigger haptic feedback on the device.
- Available kinds: `LongPress`, `VirtualKey`, `KeyboardTap`, `Confirm`, `Reject`, `ToggleOn`, `ToggleOff`, etc.
