# GPVPL - General Purpose Visual Programming Language

## Table of Contents
1. [Table of Contents](#table-of-contents)
2. [Introduction](#introduction)
3. [Roadmap](#roadmap)
4. [Plug and Play Front-end](#plug-and-play-front-end)


## Introduction
GPVPL is a Visual Programming Language built with two goals.

### A General Purpose Language
A lot of the widely used Visual Programming Languages are built either for education (Scratch, Snap!), built to function inside specific applications (Blender's node graphs) or built for specific use cases (Cameleon, Nodal).

GPVPL is being built with the goal to be a general purpose language that can be used for a wide variety of tasks.

### Easy transition to other languages
Some of the Visual Programming languages built for education and giving introduction to programming are tailored to work with sprites and building graphical applications.

GPVPL is being built with the goal to make it easier for users to transition to other widely used programming languages (like Java and python).
This is done by using terminology, syntax and concepts similar to these languages, making it easier for the users to correlate the concepts in those languages.

## Roadmap
| Feature / Capability                                               | Backend     | Frontend |
|--------------------------------------------------------------------|-------------|----------|
| Introduce Basic Data types - `Int`, `String`, `Float`, `Bool`      | In Progress |          |
| Introduce Basic Opeators - `+`, `-`, `*`, `/`, `%`                 | In Progress |          |
| Introduce Vairable creation and assignments                        | In Progress |          |
| Introduce Conditional operators - `>`, `<`, `>=`, `<=`, `==`, `!=` |             |          |
| Introduce `if/else` statements                                     |             |          |
| Introduce Loops                                                    |             |          |
| Introduce Functions                                                |             |          |

## Plug and Play Front-end
The backend runs in two modes:
1. Executor - In this mode, the backend will execute the code. This code can be generated from the Front-end and is a JSON file.
2. Web Server - In this mode, the backend will run as a server and expose REST endpoints. The Front-end will use this API to run the Visual code.

This means that you are not tied to the Front-end that is available in this repo. You can build your own front end and use it with the backend to run the code.
