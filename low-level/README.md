# Low-Level Code for Chatbot Project

This repository contains the low-level code and hardware designs for the Chatbot project. The code is written in MIPS assembly and is designed to interact with a custom CPU created in Logisim.

## MIPS Assembly Code

### Files:
- **`low-level.asm`**: Contains the main MIPS assembly code for handling user input, processing, and output.
- **`input.asm`**: Code for reading user input (e.g., keyboard input).
- **`memory.asm`**: Memory management code, including heap allocation.
- **`display.asm`**: Code for outputting results to the screen.

### How to Run:
1. Use a MIPS simulator like MARS or SPIM to run the assembly files.
2. Load the desired `.asm` file in the simulator and execute.

## Logisim CPU Design

The CPU is implemented in Logisim, which simulates the core hardware components.

### Files:
- **`cpu.circ`**: Main CPU design.
- **`alu.circ`**: Design of the ALU (Arithmetic Logic Unit).
- **`control_unit.circ`**: Design of the control unit.
- **`datapath.circ`**: Design of the CPU's datapath.

### How to Simulate:
1. Open the `.circ` files in Logisim.
2. Run the simulation to interact with the CPU and observe its behavior.

## Architecture

For a detailed breakdown of the architecture, please see the `docs/architecture.md` file.
