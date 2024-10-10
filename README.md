# Overview

![Diagram](https://github.com/sebxama/sebxama/blob/main/Services.png?raw=true "Diagram")

The concept is to manage raw data (SPO Triples) inputs into layers which perform Aggregation (Type, State, Order inference), Alignment (Attribute / Values Relationships inference, linking and matching) and Activation (Roles / Actors, Contexts, Interactions inference).

## Features

Once Aggregation, Alignment and Activation has been performed one should be able to manipulate Data at Context (use case) level, with Actors (data) playing Roles (Types) in interactions (Contexts execution instances).

One should be able to ask for Contexts Interactions with a desired outcome, via inference performed on which Actors should play which Roles.

One should be able to navigate previous Interactions (Contexts executions) or to create new ones (Contexts invocation).

For example, in the 'Family' context:

A cousin is the son of the brother of the father of another son.

An interaction could be:

Peter is the son of John.
John is the brother of Arthur.
Arthur is the father of Charlie.
Peter is the cousin of Charlie.

### Aggregation

Inputs: Triples SPO.
Type inference (i.e.: Subjects w./ same Attributes).
State inference (Attributes with the same Values).
Order (Inferred via Types / States hierarchies).

### Alignment

Inputs: Aggregation Triples augmented with Type, State and Order Metadata.
Information inference: Attributes / Values Relationships.
Linking inference: (Entities Relationships)
Equivalences inference (Entities, Attributes, Values Matching)

### Activation

Actors Activation in Contexts Interactions Roles according Aggregation and Alignment Metadata.

Inputs: Aggregation and Alignment augmented Triples.
Roles / Actors inference.
Contexts inference.
Interactions inference.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.

