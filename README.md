# Functionance

Functionance is a project recreating Java functions to make them more state-wise while still remaining completely type-safe. States can be tracked via three identifiers: inputs, outputs, and transformers.

Input states represent the number of inputs the implementing object has along with any transforms that can be performed on them. Each input can be composed of a new input, swapped with an existing input, or fixed to create an object with one less arity.

The output state represents the current output to the implementing object itself. Any output can be chained to a new output or consumed to produce no output.

Transformers are used to convert the inputs of an implementing object to its output. Every transformer can operate on zero to all inputs it has access to and provides the ability to handle any exception thrown. An extension done by functions allows for new inputs to be appended onto the end of the existing function or curry the function into some sequence of functions for execution.

## License

The entire project is licensed under Mozilla Public License 2.0. This does allow use in commercial, patent, and private use provided the source is disclosed under the same license and copyright. This project does not allow use of trademarks held by ChampionAsh5357 and provides no warranty or liability for any issues that may occur by using this project.