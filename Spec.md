# Application Intelligence

## Semantic Streams Augmentation

2026 Sebastián Samaruga. [https\://sebxama.blogspot.com](https://sebxama.blogspot.com) 

This work is licensed under a [Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License](https://creativecommons.org/licenses/by-nc-sa/4.0/).

**Table of Contents**

[Summary](#summary)

[Infer Intra and Inter Application Use Cases](#infer-intra-and-inter-application-use-cases)

[Features Exposing the Unified Systems Facade](#features-exposing-the-unified-systems-facade)

[Base Model](#base-model)

[Resources](#resources)

[Occurrences](#occurrences)

[Statement Occurrences](#statement-occurrences)

[CSPO Occurrences](#cspo-occurrences)

[Kinds Occurrences](#kinds-occurrences)

[Statements](#statements)

[Contexts, Subjects, Predicates, Objects](#contexts,-subjects,-predicates,-objects)

[Context, Subject, Predicate, Object Kinds](#context,-subject,-predicate,-object-kinds)

[Kinds as Extensional Functional Definitions](#kinds-as-extensional-functional-definitions)

[Context’s ContextKind(s) Dimensional Roles](#context’s-contextkind\(s\)-dimensional-roles)

[1\. Contexts as Dimensional Points](#1.-contexts-as-dimensional-points)

[2\. ContextKind(s) as a Higher-Order Dimensional Model](#2.-contextkind\(s\)-as-a-higher-order-dimensional-model)

[3\. Possible Inferences from Dimensional Contexts](#3.-possible-inferences-from-dimensional-contexts)

[4\. Dimensional Ordering: Previous, Current and Next](#4.-dimensional-ordering:-previous,-current-and-next)

[5\. Inferring ContextKinds from Sets, FCA, CPPE and ML](#5.-inferring-contextkinds-from-sets,-fca,-cppe-and-ml)

[6\. Integration with Aggregation, Alignment and Activation](#6.-integration-with-aggregation,-alignment-and-activation)

[7\. Illustrative Use Cases](#7.-illustrative-use-cases)

[8\. Inference Materialization and Provenance](#8.-inference-materialization-and-provenance)

[9\. Resulting Principle](#9.-resulting-principle)

[Base Model Representations](#base-model-representations)

[RDF Model Representation](#rdf-model-representation)

[Sets Based Model Representation](#sets-based-model-representation)

[Sets layout for Dimensional Analysis](#sets-layout-for-dimensional-analysis)

[1\. Formalizing the Sets Layout](#1.-formalizing-the-sets-layout)

[2\. Fundamental Set Operations](#2.-fundamental-set-operations)

[3\. Deriving Kinds from Dimensional Sets](#3.-deriving-kinds-from-dimensional-sets)

[4\. Comparing Contexts and Inferring Dimensional Relationships](#4.-comparing-contexts-and-inferring-dimensional-relationships)

[5\. Possible Inferences and Use Cases Based on Set Operations](#5.-possible-inferences-and-use-cases-based-on-set-operations)

[6\. Integration into the Augmentation Pipeline](#6.-integration-into-the-augmentation-pipeline)

[7\. Materialization, Provenance and Incremental Recalculation](#7.-materialization,-provenance-and-incremental-recalculation)

[8\. Resulting Principle](#8.-resulting-principle)

[ISO TMRM Model Representation](#iso-tmrm-model-representation)

[FCA Context Lattices Model Representation](#fca-context-lattices-model-representation)

[XML Model Representation](#xml-model-representation)

[Representations Summary](#representations-summary)

[Execution Model: Augmentation Agents Pipeline](#execution-model:-augmentation-agents-pipeline)

[Homoiconic (code as data) approach](#homoiconic-\(code-as-data\)-approach)

[Comparisons: Dimensional axis Order and Matching](#comparisons:-dimensional-axis-order-and-matching)

[Messaging Infrastructure](#messaging-infrastructure)

[Messaging Format: TreeGraph](#messaging-format:-treegraph)

[Datasources](#datasources)

[Stream-Oriented Merge, Fold and Unfold of Layered Statements](#stream-oriented-merge,-fold-and-unfold-of-layered-statements)

[Fold and Unfold as the Stream Context Resolution Operation](#fold-and-unfold-as-the-stream-context-resolution-operation)

[Merge as the Central Stream Contexts Operation](#merge-as-the-central-stream-contexts-operation)

[Possible Merge Approaches](#possible-merge-approaches)

[RDF Merge](#rdf-merge)

[TMRM Merge](#tmrm-merge)

[FCA Merge](#fca-merge)

[CPPE Based FCA / Model Primitives Merge](#cppe-based-fca-/-model-primitives-merge)

[Sets Model Based Merge](#sets-model-based-merge)

[Integration into Streams Processing](#integration-into-streams-processing)

[Streaming Agents Augmentation Pipeline](#streaming-agents-augmentation-pipeline)

[Aggregation Service Agent](#aggregation-service-agent)

[Aggregation Agent Domain Model](#aggregation-agent-domain-model)

[Aggregation Agent Merge / Fold / Unfold](#aggregation-agent-merge-/-fold-/-unfold)

[Alignment Service Agent](#alignment-service-agent)

[Alignment Agent Domain Model](#alignment-agent-domain-model)

[Alignment Agent Merge / Fold / Unfold](#alignment-agent-merge-/-fold-/-unfold)

[Activation Service Agent](#activation-service-agent)

[Activation Agent Domain Model](#activation-agent-domain-model)

[Activation Agent Merge / Fold / Unfold](#activation-agent-merge-/-fold-/-unfold)

[Helper Services](#helper-services)

[Registry Service](#registry-service)

[Naming Service](#naming-service)

[Index Service](#index-service)

[Dynamic API Endpoints](#dynamic-api-endpoints)

[Dynamic API Endpoints Integration](#dynamic-api-endpoints-integration)

[Monadic Context & Interaction Pipeline](#monadic-context-&-interaction-pipeline)

[Protocol Execution & Resource Traversal](#protocol-execution-&-resource-traversal)

[Generic Dynamic API Endpoints Browser / Designer](#generic-dynamic-api-endpoints-browser-/-designer)

[Dynamic API Endpoints API Architecture & Monadic Workflow](#dynamic-api-endpoints-api-architecture-&-monadic-workflow)

[Monadic Execution Model: State and IO Monads](#monadic-execution-model:-state-and-io-monads)

[Activation Statements Transformation Flow](#activation-statements-transformation-flow)

[Conversational Session & Resource Navigation Pattern](#conversational-session-&-resource-navigation-pattern)

[Dynamic API Endpoints Summary](#dynamic-api-endpoints-summary)

[Resource Representation and Navigational State](#resource-representation-and-navigational-state)

[State Monad: API Navigation and Augmentation State](#state-monad:-api-navigation-and-augmentation-state)

[IO Monad: API Representation ↔ Activation Statements](#io-monad:-api-representation-↔-activation-statements)

[Generic Contexts / Roles / Actors / Interactions Resources](#generic-contexts-/-roles-/-actors-/-interactions-resources)

[Browsing a Use Case as REST Resource Navigation](#browsing-a-use-case-as-rest-resource-navigation)

[Resource Rendering from Activation Production Statements](#resource-rendering-from-activation-production-statements)

[Executing an Interaction](#executing-an-interaction)

[Parent, Child and Placeholder Resources](#parent,-child-and-placeholder-resources)

[API Facade and Augmentation Pipeline Feedback](#api-facade-and-augmentation-pipeline-feedback)

[Generic Dynamic API Protocol](#generic-dynamic-api-protocol)

[Generic Dynamic API Endpoints Browser / Designer](#generic-dynamic-api-endpoints-browser-/-designer-1)

[Implementation Techniques](#implementation-techniques)

[Leverage TMRM (ISO Topic Maps Reference Model)](#leverage-tmrm-\(iso-topic-maps-reference-model\))

[Leverage Dimensional Features](#leverage-dimensional-features)

[Leverage Formal Grammars](#leverage-formal-grammars)

[Leverage RDF, RDFS, OWL and SPARQL](#leverage-rdf,-rdfs,-owl-and-sparql)

[Leverage Sets Model](#leverage-sets-model)

[Leverage ML and LLMs](#leverage-ml-and-llms)

[Leverage MCP (Model Context Protocol)](#leverage-mcp-\(model-context-protocol\))

[Leverage FCA](#leverage-fca)

[FCA-based Relational Schema Inference](#fca-based-relational-schema-inference)

[Leverage CPPE](#leverage-cppe)

[Algebraic Semantic Embeddings (CPPE):](#algebraic-semantic-embeddings-\(cppe\):)

[Prime Numbers Identifiers:](#prime-numbers-identifiers:)

[Prime ID Embeddings:](#prime-id-embeddings:)

[CPPE. FCA-based Embeddings: A Deterministic Approach:](#cppe.-fca-based-embeddings:-a-deterministic-approach:)

[Relational Context Vectors](#relational-context-vectors)

[Schema Archetypes:](#schema-archetypes:)

[Subsumption:](#subsumption:)

[Property Chains](#property-chains)

[Querying and Traversal by Numerical Properties:](#querying-and-traversal-by-numerical-properties:)

[Graph Pipeline Specification: CPPE Algebra for Pipeline Stream Actions:](#graph-pipeline-specification:-cppe-algebra-for-pipeline-stream-actions:)

[1\. Algebraic Definitions](#1.-algebraic-definitions)

> > > [The Prime Product Rule:](#the-prime-product-rule:)

[2\. Pipeline Stream Operators (The CPPE Monad)](#2.-pipeline-stream-operators-\(the-cppe-monad\))

> > > [A. The "Contains" Operator (Sub-graph Filtering):](#a.-the-"contains"-operator-\(sub-graph-filtering\):)

> > > [B. The "Intersection" Operator (Aggregation):](#b.-the-"intersection"-operator-\(aggregation\):)

> > > [C. The "Axis Shift" Operator (Alignment):](#c.-the-"axis-shift"-operator-\(alignment\):)

[3\. Pipeline Stages Revisited via CPPE:](#3.-pipeline-stages-revisited-via-cppe:)

> > > [3.1 Aggregation (Algebraic Type Inference):](#3.1-aggregation-\(algebraic-type-inference\):)

> > > [3.2 Alignment (Vector/Prime Space Prediction):](#3.2-alignment-\(vector/prime-space-prediction\):)

> > > [3.3 Activation (State Transition Product):](#3.3-activation-\(state-transition-product\):)

[Leverage W3C DIDs (Distributed Resource Identifiers)](#leverage-w3c-dids-\(distributed-resource-identifiers\))

[The resulting principle](#the-resulting-principle)

[Techniques Summary](#techniques-summary)

[Appendix: Enterprise Scenario: Cross-System Order-to-Delivery Integration](#appendix:-enterprise-scenario:-cross-system-order-to-delivery-integration)

[1\. Raw Source Data Streams (Datasource Ingestion)](#1.-raw-source-data-streams-\(datasource-ingestion\))

[2\. Stage 1: Aggregation Service Agent (Data Layer \- Type & Role Inference)](#2.-stage-1:-aggregation-service-agent-\(data-layer---type-&-role-inference\))

[Processing & Inference](#processing-&-inference)

[Production Output (Property Quad Statements)](#production-output-\(property-quad-statements\))

[3\. Stage 2: Alignment Service Agent (Information Layer \- Schema Matching & Identity Resolution)](#3.-stage-2:-alignment-service-agent-\(information-layer---schema-matching-&-identity-resolution\))

[Processing & Inference](#processing-&-inference-1)

[Production Output (Rule Quad Statements)](#production-output-\(rule-quad-statements\))

[4\. Stage 3: Activation Service Agent (Knowledge Layer \- Use Cases & Behaviors)](#4.-stage-3:-activation-service-agent-\(knowledge-layer---use-cases-&-behaviors\))

[Processing & Inference](#processing-&-inference-2)

[Production Output (Executable Context Quad Statements)](#production-output-\(executable-context-quad-statements\))

[5\. Unified Contexts & Interactions API (Dynamic Endpoint Execution)](#5.-unified-contexts-&-interactions-api-\(dynamic-endpoint-execution\))

[Architectural Summary Table](#architectural-summary-table)

[Execution Flow Example](#execution-flow-example)

[Appendix: Use Case Discovery and Unified Facade](#appendix:-use-case-discovery-and-unified-facade)

[Use Case Discovery Pipeline](#use-case-discovery-pipeline)

[Intra-Application Use Case Discovery](#intra-application-use-case-discovery)

[Inter-Application Use Case Discovery](#inter-application-use-case-discovery)

[Use Case as an Inferred Semantic Contract](#use-case-as-an-inferred-semantic-contract)

[Use Case Discovery from Dimensional and State Structures](#use-case-discovery-from-dimensional-and-state-structures)

[Composite Interactions](#composite-interactions)

[Unified Read Facade and Unified Interaction Facade](#unified-read-facade-and-unified-interaction-facade)

[Unified Resource Facade](#unified-resource-facade)

[Unified Interaction Facade](#unified-interaction-facade)

[Traceability from Facade Interaction to Datasources](#traceability-from-facade-interaction-to-datasources)

[Datasource Synchronization](#datasource-synchronization)

[Facade Generation Principle](#facade-generation-principle)

[Relationship to Implementation Techniques](#relationship-to-implementation-techniques)

[Resulting architecture](#resulting-architecture)

[1\. Intra-application: Employee lifecycle facade](#1.-intra-application:-employee-lifecycle-facade)

[What Aggregation discovers](#what-aggregation-discovers)

[What Alignment discovers](#what-alignment-discovers)

[What Activation exposes](#what-activation-exposes)

[2\. Intra-application: Order fulfillment facade](#2.-intra-application:-order-fulfillment-facade)

[Aggregation](#aggregation)

[Alignment](#alignment)

[Activation](#activation)

[3\. Inter-application: Customer 360 facade](#3.-inter-application:-customer-360-facade)

[Aggregation](#aggregation-1)

[Alignment](#alignment-1)

[Unified facade](#unified-facade)

[4\. Inter-application: University ↔ employment ecosystem](#4.-inter-application:-university-↔-employment-ecosystem)

[Aggregation](#aggregation-2)

[Alignment](#alignment-2)

[Activation](#activation-1)

[5\. Inter-application: Product-to-service lifecycle](#5.-inter-application:-product-to-service-lifecycle)

[Alignment features](#alignment-features)

[Unified facade](#unified-facade-1)

[6\. Inter-application: Lead → Customer → Contract → Service](#6.-inter-application:-lead-→-customer-→-contract-→-service)

[Aggregation](#aggregation-3)

[Alignment](#alignment-3)

[Activation](#activation-2)

[7\. Inter-application: Finance reconciliation](#7.-inter-application:-finance-reconciliation)

[Alignment](#alignment-4)

[Activation](#activation-3)

[8\. A more interesting class: inferred "composite" interactions](#8.-a-more-interesting-class:-inferred-"composite"-interactions)

[How the pipeline would infer these use cases](#how-the-pipeline-would-infer-these-use-cases)

[What the unified facade could actually expose](#what-the-unified-facade-could-actually-expose)

[Appendix: ChatGPT Conversation](#appendix:-chatgpt-conversation)

[Appendix: Gemini Conversation](#appendix:-gemini-conversation)

# Summary {#summary}

This document describes a semantic RDF based data integration and intelligence framework proposal. By means of Aggregation, Alignment and Activation graphs stream processing in the form of Context, Subject, Predicate, Object Statements inputs: Infer graph Resource types, Occurrence Roles (Aggregation). Merge equivalent entities, complete missing attributes / links / relationships (Alignment). Infer Use Case types (Contexts / Roles) and Use Case executions (Interactions / Actors): Activation.

From raw source graph data in the form of RDF Statements, from any backend / datasource capable of being exported into an RDF graph, obtain an executable representation of the underlying models: integrated applications backends / datasources graph representations. Intra and inter integrated applications Use Cases will be discovered and exposed through an unified Contexts and Interactions API.

The underlying integrated applications backends / datasources are kept in sync with this framework inferences and Context(s) Interaction(s) data and state flows and transforms. The integrated applications keep working, reflecting changes made via these integration mechanisms, while this framework behaves as an interaction integration “agent”, capable of viewing and exposing an unified integration view of all the underlying integrated applications for further development of inter / intra application integration use cases.

A unified integration facade is generated from the semantic Contexts and Interactions inferred over the integrated datasource graph. Resource views expose the resulting integrated state; Interaction endpoints expose executable Contexts and state transitions; and each facade operation remains connected to the underlying Statements, Rules and application resources from which it was inferred.

The integrated facade is not a canonical CRUD API generated from a merged database schema. It is a semantic interaction facade generated from inferred Resources, Kinds, Relationships, Contexts, Roles, Actors and Interactions. Resource views provide unified read access, while Activation provides contextual operations whose execution may span multiple underlying applications.

## Infer Intra and Inter Application Use Cases {#infer-intra-and-inter-application-use-cases}

* **Intra-Application Schema and Type Discovery (Data Aggregation)**: Raw RDF graph statements exported from individual backend datasources can be processed to infer hidden object types, property definitions, and relational schemas. For example, analyzing raw triple statements like (:dev1, :worksOn, :projA) allows the framework to infer a structural DeveloperWorksOnProject schema with defined domain (Developer) and range (Project) types.  
* **Inter-Application Entity and Identity Resolution (Information Alignment)**: Equivalent entities and relationships across disparate backend streams can be merged, filling in missing attributes or cross-system links. This includes discovering structural analogies across different domain contexts, such as recognizing that Employee is to Employer in a corporate backend as Student is to School in an academic backend.  
* **State Transition and Event Flow Tracking (Information Alignment)**: Sequential data updates within or across applications can be mapped into ordered state networks. For instance, tracking previous, current, and next (PCN) states allows systems to infer behavioral paths like (Single, Marriage, Married) or employment cycles like (Unemployed, Employment, Employee).  
* **Cross-System DCI Contexts and Role Executions (Knowledge Activation)**: Inter-application interactions are mapped into executable Data-Context-Interaction (DCI) contexts. Multi-department operational scenarios—such as linking employee role definitions, position timelines, and departmental interactions—are unified into an executable context statement like (EmploymentDepartmentCK, EmploymentDepartmentRoleSK, EmploymentDepartmentActorPK, EmploymentDepartmentRoleOK).

* The framework infers Use Case types by modeling them as Contexts and Roles.  
* The framework infers Use Case executions by modeling them as Interactions and Actors.  
* By utilizing Machine Learning and LLMs, the system can estimate or infer state transitions and interaction outcomes directly from contextual information.  
* Using Dimensional Features, the framework infers types and instances of state transition networks (Previous, Current, Next) based on events, enabling the system to recognize structural hierarchies and contextual behaviors.  
* Through FCA (Formal Concept Analysis), the framework infers relational schemas and upper-level ontology structures from observed statement patterns, providing the semantic vocabulary for roles and interactions.

## Features Exposing the Unified Systems Facade {#features-exposing-the-unified-systems-facade}

* **Dynamic Contexts and Interactions API**: A HAL-like, discoverable API layer that renders user interfaces and execution boundaries directly over activated knowledge statements. It exposes both system states (nouns/properties) and role behaviors (verbs) to represent interactive workflows dynamically. The framework exposes HAL-like or discoverable behavior APIs over activated knowledge statements, rendering message-driven interfaces for context interaction instances and role executions.  
* **Reactive Stream Augmentation Pipeline**: An asynchronous messaging pipeline (operating across Aggregation, Alignment, and Activation topics) that processes source data through merge, fold, and unfold stream operations. This keeps underlying backends in sync with inferred context and state changes while exposing a unified integration view.  
* **Model Context Protocol (MCP) Binding**: An interface layer that exposes discovered domain resources, alignment tools, and executable DCI interactions as context-aware tool endpoints for external AI agents and LLMs. This feature exposes the discovered semantic resources, contexts, and executable interactions as discoverable tool interfaces, allowing external AI agents and LLMs to dynamically inspect and trigger behaviors exposed by the unified API.  
* **Distributed DID Registry and Endpoint Discovery**: A W3C Decentralized Identifier (DID) and DID Document registry layer that manages global resource identities, tracks data provenance, and advertises system service capabilities across administrative boundaries. DIDs establish cross-boundary identity and act as a distributed semantic registry, allowing the framework to advertise semantic business capabilities, synchronize graph states, and discover service endpoints across independently managed data sources.  
* **CPPE Numerical Index and Query Engine**: An $O(1)$ arithmetic query mechanism that uses Contextual Prime Product Embeddings to execute sub-graph filtering (via prime divisibility/remainder), similarity matching (via Greatest Common Divisor), and instant type subsumption without performing expensive graph joins. This feature uses deterministic prime number mathematics for instant type checking and reactive stream filtering, triggering activations (like webhooks or UI changes) when a calculated state transition product matches a pre-calculated "Success Pattern".  
* **ISO Topic Maps Reference Model (TMRM):** This feature provides the implementation-independent semantic substrate that handles deterministic identity resolution and topic merging, giving the pipeline a unified graph representation without losing the provenance or context of the underlying datasources.  
* **Formal Grammars:** The system utilizes grammatical production rules to formalize stream processing, evaluating rules and parsing raw statements to dynamically generate prompts, contextual rules, and interaction executions.  
* **RDF, RDFS, OWL, and SPARQL:** These standardized graph infrastructures guarantee universal interoperability, allowing the facade to ingest, match, and query raw data streams from any legacy backend capable of exporting an RDF graph.

Based on the provided specification, intra- and inter-application use cases are inferred primarily through the "Activation" (Knowledge) phase of the framework's semantic stream processing pipeline, while multiple specific implementation techniques are leveraged to expose these as a unified systems facade.

The pipeline integrates source system data through three sequential stream processing stages:

* **Aggregation (Data Layer):** The framework ingests raw Context, Subject, Predicate, Object (CSPO) RDF statements from the source systems and infers foundational types and roles. In the employment example, raw data is aggregated into production properties like EmploymentContextKind, EmployeeSubjectKind, EmploymentRelationshipPredicateKind, and EmployerObjectKind.  
* **Alignment (Information Layer):** The pipeline aligns these aggregated properties to establish dimensional rules, ontology matches, and links. It builds rule statements by linking elements such as an EmploymentRelationshipCK (Context), an EmployeeRoleSK (Subject), and an EmployeePositionAtDatePK (Predicate).  
* **Activation (Knowledge Layer):** The framework materializes the aligned rules into executable use cases, roles, and interactions. It translates the HR rules into active contexts, producing statements that define the EmploymentDepartmentCK (Context), EmploymentDepartmentRoleSK (Role), and EmploymentDepartmentActorPK (Actor).

By merging, folding, and unfolding these statement streams, the facade infers resource types, matches equivalent entities across disparate datasources, and completes missing attributes to expose the resulting behaviors as a unified, executable domain model.

# Base Model {#base-model}

class Resource  
\+ ID : URI  
\+ primeID : BigInteger  
\+ occurrences : Occurrence\[\]  
\+ apply(res: Resource) : Resource

class Occurrence extends Resource    
\+ player : Resource  
\+ context : Resource    
\+ role : Kind

class Statement extends Resource  
\+ context : Occurrence  
\+ subject : Occurrence  
\+ predicate : Occurrence  
\+ object : Occurrence

@deprecated: Occurrence with role of ContextKind type  
class Context extends Occurrence  
\+ role : ContextKind

class Context: Root Context (Dimension Points) ContextKind (all Statements Context’s Occurrences Dimension Points)

@deprecated: Occurrence with role of SubjectKind type  
class Subject extends Occurrence  
\+ role : SubjectKind

class Subject: Root Subject SubjectKind (all Statements Subject’s Occurrences)

@deprecated: Occurrence with role of PredicateKind type  
class Predicate extends Occurrence  
\+ role : PredicateKind

class Predicate: Root Predicate PredicateKind (all Statements Predicate’s Occurrences)

@deprecated: Occurrence with role of ObjectKind type  
class Object extends Occurrence  
\+ role : ObjectKind

class Object: Root Object ObjectKind (all Statements Object’s Occurrences)

interface Kind\<PlayerType extends Occurrence,  
          AttributeType extends Occurrence,  
          ValueType extends Occurrence\>  
getPlayers : Occurrence\[\]  
getAttributes : Occurrence\[\]  
getValues : Occurrence\[\]

// Aggregates Statements Dimensional Points (Subject Players, Predicate Attributes, Object Values)  
class ContextKind extends Resource implements Kind\<Subject, Predicate, Object\>

class SubjectKind extends Resource implements Kind\<Subject, Predicate, Object\>

class PredicateKind extends Resource implements Kind\<Predicate, Subject, Object\>

class ObjectKind extends Resource implements Kind\<Object, Predicate, Subject\>

## Resources {#resources}

Everything is a Resource identified by an URI, assigned a Prime Number ID, keeping track of its Occurrences and thus enabling the calculation of their CPPE (Prime Number Contextual Embedding) by means of the product of its Prime Number ID by the Prime Number IDs of the other Resources in their Occurrences contexts.

## Occurrences {#occurrences}

Participation of a Resource in an Occurrence in a given Role (Kind) in a given Context (Statement Kind role).

### Statement Occurrences {#statement-occurrences}

Statements are Resources whose occurrences are their Subjects, Predicates and Objects in a given Dimensional Context space. Statement Contexts (Quads Contexts) ContextKinds aggregates all of the dimensional axes (SPOs) of the corresponding Statement Occurrence.

### CSPO Occurrences {#cspo-occurrences}

@deprecated: CSPOs are Occurrence(s) with their corresponding Statement position Kind types (ContextKind, SubjectKind, PredicateKind, ObjectKind) Statement Occurrence roles.

Context, Subject, Predicate, Object as Resource(s) Occurrences. CSPO occurring Statement Context where they are in Context, Subject, Predicate and Object Kinds Roles.

CSPOs Occurrence instances as wrapped arbitrary Resource Occurrence Context

### Kinds Occurrences {#kinds-occurrences}

Kinds encodes Player, Attribute, Value triples scoped by their Kind (Resource) Context Occurrence.

Reify as Context, Subject, Predicate, Object. Occurrences of the Kind as Resource. Kinds as Resources: Kinds occurring in Statements in C, S, P, O Roles.

Kind Functional Definition: Statement Contexts (occurring Statement Contexts) for a given Player (context) a given Attribute has a corresponding functional Value.

## Statements {#statements}

Context, Subject, Predicate and Object Occurrences (CSPO) tuples.

Context, Subject, Predicate, Object (CSPO) Statement Occurrences have a role (Kind) in their given Statement Occurrence Context.

Kinds: ContextKind, SubjectKind, PredicateKind, ObjectKind (CK, SK, PK, OK) are themselves CSPOs (Resources) respectively and can participate in a Statement Context as Occurrences. Types of Statements:

* SPO Statements  
* SPO / Kinds Statements (recursive Kinds)  
* Kinds only Statements (recursive Kinds)

This is further leveraged in the Augmentation Layers Domain Model definitions section.

## Contexts, Subjects, Predicates, Objects {#contexts,-subjects,-predicates,-objects}

@deprecated: CSPOs are Occurrence with their corresponding Statement position Kind types (ContextKind, SubjectKind, PredicateKind, ObjectKind) Statement roles.

The role of a Resource Occurrence in a Statement is typed by its Statement Occurrence position. A Resource can occur in more than one role or occurrence type (CSPO) in different Statements. The type of the role (Kind) of the Resource Occurrence is determined by the type of the position it plays in a given Statement.

## Context, Subject, Predicate, Object Kinds {#context,-subject,-predicate,-object-kinds}

Kinds encodes Player, Attribute, Value triples scoped by their Kind (Resource) Context Occurrence.

Aggregation of PlayerType(s) Resource Occurrences (SPOs) by common AttributeType(s) (types) and then by common ValueTypes(s) (states). Parameterized interface for each Kind type (CK, SK, PK, OK).

Kinds can be aggregated from raw CSPO Occurrences from any combination of C, S, P, O / CK, SK, PK, OK Statement Occurrence types. This allows for recursive Kinds definitions (folding). This is further leveraged in the Augmentation Layers Domain Model definitions section.

Kinds are a kind of “type inference”: if a Subject shares common attributes with another Subject, it is of the same Kind “type”. If their common attributes share common values, it is of the same Kind “state”.

Root Kinds are the Kinds corresponding to the CSPO Occurrences Statements positions. They have no attributes nor values, they just tag an Occurrence as being of an CSPO Occurrence position in a Statement.

Kinds hierarchies: basic inheritance, if a Subject attribute set is the superset of another Subject attribute set, it can be regarded as an “extension” of the first Subject. Leverage this with other inference mechanisms (FCA, for example).

Kinds ordering: a Subject “extended” by another Subject attributes set can be regarded as being “before” the first Subject. This assumes the existence of a super type is necessary for the existence of a sub type.

Kinds are represented and serialized by Statements whose Statement Contexts are the Kind instance itself (Kind reified Context Resource Occurrence), and their Subjects, Predicates and Objects plays the PlayerType, AttributeType and ValueType of the Kind definition. Thus, the definition of a Kind is the set of Statements of its corresponding Kind as Resource Occurrence of their Statement Contexts.

### Kinds as Extensional Functional Definitions {#kinds-as-extensional-functional-definitions}

Kind Statements can be regarded as the definition of a Function by extension. Their Statement Contexts Occurrence Resources are the Function name or signature. Their PlayerType(s) instances group their mappings by “context” and their AttributeType(s) and ValueType(s) instances are the Function domain / range corresponding value pairs. Subject 

* CK: Context (Contexts), Domain (Subject), Range (Predicates): aGivenContextKind(C, S): P  
* SK: Context (Subjects), Domain (Predicates), Range (Objects): aGivenSubjectKind(S, P): O  
* PK: Context (Predicates), Domain (Subjects), Range (Objects): aGivenPredicateKind(P, S): O  
* OK: Context (Objects), Domain (Predicate), Range (Subject): aGivenObjectKind(O, P): S

**Kinds based functional merge:**

If aKind(S1) \= A, and aKind(S2) \= A, S1 and S2 are equivalent in a given context.

If aKind(S1) \= A, aKind(next(S1)) \= next(A).

Functional Composition (align, sort, link completion, merge).

**Kinds Functional Comprehensions:**

Kinds: extensional functions definitions. Functions Comprehensions: infer Kinds Functions from CPPE embeddings vía Helpers / ML. Resource Merge / Apply: Kinds inferred Functions inference.

### Context’s ContextKind(s) Dimensional Roles {#context’s-contextkind(s)-dimensional-roles}

Statements are dimensionally aggregated through their Context(s) ContextKind(s). A given Context Occurrence of a Context Resource plays the role of its ContextKind which aggregates all the given Statement Context’s Context Point dimensional Statements (Subjects, Predicates, Objects as the Player, Attribute, Value roles of the ContextKind) corresponding to the Statement Dimensional Point..

TODO: Dimensional Contexts (Context’s Occurrences ContextKind roles) shall encode data, information and knowledge which will allow to reference, classify, relate, order, group and address specific Statement(s).  
TODO: Infer Order and relationships renderable as a previous, current, next materialized relation statements (containment, time, etc.)  
TODO: Subject, Predicate, Object Kinds as ContextKind(s) Players, Attributes and Values?  
TODO: Infer Dimensional Contexts Occurrences ContextKind(s). ML / Clustering?

Statements are dimensionally aggregated through their Contexts and the ContextKinds associated with their Context occurrences. A Context Resource provides a scope in which Subject, Predicate and Object occurrences participate in Statements. Its ContextKind aggregates the structural characteristics of that scope, treating Subjects as Players, Predicates as Attributes, and Objects as Values.

A Context is therefore more than a container for Statements. It can be regarded as a dimensional point whose aggregated Statement structure describes a particular data scope, situation, state, event, relationship, or interaction. ContextKinds provide the means to classify such dimensional points, compare them with other Contexts, discover relationships among them, and materialize inferred structures as additional Statements.

The objective is to infer sufficient dimensional structure to reference, classify, relate, order, group, compare and address particular Statements and their participating Resources. These inferences provide a basis for the subsequent Alignment and Activation stages, where structural correspondences become semantic relationships and executable Contexts, Roles, Actors and Interactions.

#### 1\. Contexts as Dimensional Points {#1.-contexts-as-dimensional-points}

For a given Context Resource ![C][image1], let its observed dimensional statements be:

![Rendered mathematical expression: D(C)=\\{(S,P,O)\\mid(C,S,P,O)\\text{ is an observed Statement}\\}][image2]

The dimensional profile of ![C][image3] is obtained by aggregating the participating Resources and their relationships:

* Players: Subject Resources and, where available, their SubjectKinds.  
* Attributes: Predicate Resources and their PredicateKinds, representing properties, relationships or dimensions.  
* Values: Object Resources and their ObjectKinds, representing values, states, targets or related entities.

The resulting ContextKind is an extensional description of the observed structure of a Context. It can be represented through the existing Kind\<PlayerType, AttributeType, ValueType\> abstraction:

ContextKind\<Subject, Predicate, Object\>

A ContextKind can consequently represent the observed functional structure of a Context, including which Players participate, which Attributes characterize them, and which Values occur for those Attributes.

The word *functional* describes the intended Player–Attribute–Value mapping. It does not imply that every Attribute necessarily has a unique Value. Where a Player may have several values for the same Attribute, or where values change over time, the model must preserve the corresponding multiple Statements and contextual distinctions. Single-valuedness, completeness and other functional constraints should be inferred or asserted only where the available evidence supports them.

Contextual dimensional profiles can be built at two complementary levels:

1. Instance-level dimensions: actual Subjects, Predicates and Objects found in a Context.  
2. Kind-level dimensions: SubjectKinds, PredicateKinds and ObjectKinds inferred from those occurrences.

For example, an employment Context may contain actual employees, employers and employment relationships. Its generalized profile may identify EmployeeSubjectKind, WorkRelationshipPredicateKind and EmployerObjectKind. The instance-level profile describes the observed facts; the Kind-level profile describes the structural pattern shared by the facts.

The two levels should remain linked so that each inferred Kind or relationship can be traced back to the source Statements and occurrences that support it.

#### 2\. ContextKind(s) as a Higher-Order Dimensional Model {#2.-contextkind(s)-as-a-higher-order-dimensional-model}

ContextKinds can themselves participate in Statements as Resources. This makes it possible to describe not only the dimensions within a Context, but also the structural relationships between Contexts.

A useful distinction is:

* A Context is a particular dimensional point or scope.  
* A ContextKind describes the structural pattern of such a point.  
* A SubjectKind, PredicateKind or ObjectKind characterizes the types of Resources participating in that structure.  
* A ContextKind occurrence associates a Context Resource with a Kind in a particular occurrence Context and Role.

For a family of related Contexts, their profiles can be aggregated into a higher-level ContextKind. Its Players, Attributes and Values may be actual Resources, Kind Resources, or recursively defined contextual structures, provided that their respective levels and roles remain explicit.

For example, a generalized order-fulfillment ContextKind could aggregate patterns involving:

* CustomerSubjectKind  
* OrderSubjectKind  
* OrderPlacementPredicateKind  
* InvoiceObjectKind  
* ShipmentObjectKind

The resulting dimensional structure describes the types of participants, relationships and states that commonly occur in order fulfillment. It does not imply that every order has an invoice or shipment; those are separate constraints or workflow expectations to be established by observed data, explicit rules or additional inference.

This recursive use of Kinds allows the framework to describe a Context's dimensional structure in the same Statement model used to describe ordinary application data. It also supports the existing Kinds-only Statements and SPO/Kinds Statements representations.

#### 3\. Possible Inferences from Dimensional Contexts {#3.-possible-inferences-from-dimensional-contexts}

Contextual aggregation creates several complementary inference opportunities.

| Inference | Evidence and mechanism | Possible result or use case |
| ----- | ----- | ----- |
| Context classification | Recurring SubjectKinds, PredicateKinds, ObjectKinds and dimensional patterns | Classify Contexts as employment, sales-order, billing or fulfillment contexts |
| Context equivalence | Equal or sufficiently compatible dimensional profiles, identifiers and contextual constraints | Recognize duplicated or equivalent representations of a Context |
| Context specialization | Attribute inclusion, additional relationships or more specific participant Kinds | Infer specialized ContextKinds, such as a particular kind of employment or order workflow |
| Context similarity | Shared dimensional features, set intersections, FCA concepts, CPPE features or ML clustering | Discover related Contexts across applications and identify candidates for further Alignment |
| Role and dimension discovery | Recurring relationships between SubjectKinds, PredicateKinds and ObjectKinds | Identify participant roles, measurement dimensions and source/destination relationships |
| Relationship analogy | Comparable dimensional patterns across different ContextKinds | Infer that Employee–Employer and Student–School exhibit analogous relational roles without asserting that the entities are equivalent |
| Ordering and precedence | Explicit sequence links, timestamps, version identifiers, event order or workflow rules | Materialize Previous, Current and Next relationships between Contexts or states |
| Containment and decomposition | Parent/child references, nesting, shared identifiers or explicit membership relationships | Infer that one Context contains or decomposes into subordinate Contexts, activities or interactions |
| State and transition inference | Differences between successive dimensional profiles and observed state-changing events | Identify lifecycle stages, possible transitions and candidate transition rules |
| Missing relationship discovery | A known Context pattern or rule is satisfied except for an expected link or value | Propose missing associations, cross-system references or incomplete workflow steps |
| Constraint and anomaly detection | Violations of learned or explicitly defined dimensional patterns | Detect unexpected values, inconsistent states, missing prerequisites or unusual relationships |
| Contextual query and addressing | Stable Context identities, Kind memberships and indexed dimensional features | Retrieve Statements by business scope, participant, relationship, lifecycle state or workflow |
| Interaction discovery | Repeated sequences of Contexts, Roles, Actors and state transitions | Identify candidate intra-application and inter-application Use Cases for Activation |

These are potential inferences rather than universally valid consequences of aggregation. Each result depends on the semantics of the source data, the quality of identity resolution, the completeness of the observations and the constraints applicable to the domain.

In particular, similarity is not identity, structural inclusion is not necessarily temporal precedence, and a missing Statement is not automatically evidence that a business event failed to occur.

#### 4\. Dimensional Ordering: Previous, Current and Next {#4.-dimensional-ordering:-previous,-current-and-next}

One of the principal uses of Contextual Dimensional Analysis is to infer and materialize ordering relationships. The existing Previous–Current–Next (PCN) model can be applied both to the states within a Resource's lifecycle and to successive Contexts in a larger process.

Possible ordering dimensions include:

* Temporal order: events ordered by trustworthy timestamps, sequence numbers or version history.  
* Process order: stages ordered by explicit workflow rules, dependencies or observed execution sequences.  
* Containment order: a parent Context containing subordinate Contexts or Interactions.  
* Structural order: a more general dimensional profile related to a more specialized profile through Attribute or Kind inclusion.  
* Dependency order: one Context or Interaction requiring the completion of another.  
* State-transition order: a Resource changing from one recognized state to another.

These relations may be represented as materialized relation Statements, for example:

(:OrderPlacedContext, :next, :OrderInvoicedContext)

(:OrderInvoicedContext, :previous, :OrderPlacedContext)

(:FulfillmentContext, :contains, :ShipmentContext)

The examples describe possible inferred outputs, not predefined facts. The source events, identifiers, state profiles or applicable rules must justify the corresponding relation.

The framework should distinguish partial order, total order, containment, causal dependency and structural specialization. They are different semantic relations even when they can all be represented as graph edges. Two events may be concurrent, timestamps may be missing or inconsistent, and different process instances may follow different paths. The model should preserve uncertainty instead of forcing every set of Contexts into a single sequence.

Where ordering can be established, the resulting Statements become inputs to subsequent aggregation, alignment and activation. Where ordering is only suggested by statistical patterns, it should remain a candidate relation until validated or supported by sufficient evidence.

#### 5\. Inferring ContextKinds from Sets, FCA, CPPE and ML {#5.-inferring-contextkinds-from-sets,-fca,-cppe-and-ml}

Context dimensional inference can combine deterministic operations with more exploratory inference mechanisms.

Sets-based dimensional analysis

For each Context, maintain sets of participating Subjects, Predicates, Objects and their inferred Kinds. Set equality and intersection can identify recurring patterns; inclusion can identify additional dimensions or possible specializations; differences can expose missing or divergent relationships.

The Sets Layout for Dimensional Analysis represents this as a snapshot of the Resources and their Roles in a given Context Dimensional Point. The intersections of the Subject, Predicate and Object sets establish the possible Statement combinations, while the actual observed Statements determine which combinations are supported facts. A possible combination must not be materialized as an observed Statement merely because its components occur together elsewhere.

Formal Concept Analysis (FCA)

FCA can discover groups of Contexts sharing common attributes and organize those groups into concept lattices. This provides a way to infer ContextKind hierarchies, common dimensional signatures, specialized Context families and structural correspondences between data sources.

Context profiles may be compared through different FCA projections, including Subjects as contexts, Predicates as contexts and Objects as contexts. Their relationships can reveal which properties distinguish one Context family from another and which common features support a more general Kind.

CPPE and numerical embeddings

Contextual Prime Product Embeddings can support indexed comparison, candidate matching and traversal based on Resource and occurrence structure. Similarity or shared structural factors can be used to identify potentially related Contexts and focus further graph analysis.

A numerical match is evidence for further comparison, not by itself a semantic identity assertion. The interpretation of a CPPE result must remain tied to the actual Resources, Roles, Contexts and Statements from which the embedding was derived.

Machine Learning and clustering

ML can infer candidate ContextKinds from recurring dimensions, group previously unclassified Contexts, detect outliers and suggest possible state transitions or relationships. Classification is appropriate for candidate ContextKind assignment, clustering for Context alignment, and sequence or predictive models for possible transitions and outcomes.

Features should include relevant structural and contextual information, such as participating Kinds, Predicate patterns, event ordering and provenance. Training data and inferred relationships should remain traceable, while confidence, supporting evidence and alternative explanations should be retained wherever the inference is probabilistic.

LLMs and semantic interpretation

LLMs may help interpret labels, descriptions, relationship patterns and domain-specific language when deterministic matching is insufficient. They can propose mappings such as an employment Context corresponding structurally to a studentship Context. Such mappings should be represented as candidate alignments and validated against graph structure and applicable constraints before they drive identity merges or executable Interactions.

#### 6\. Integration with Aggregation, Alignment and Activation {#6.-integration-with-aggregation,-alignment-and-activation}

Context dimensional inference participates in all three augmentation stages.

Aggregation — Data layer

The Aggregation Agent folds raw CSPO Statements into ContextKind, SubjectKind, PredicateKind and ObjectKind property Statements. It collects dimensional profiles, identifies common structural characteristics and distinguishes instance-level values from generalized types.

Outputs may include inferred Context classifications, recurring dimensional signatures, source provenance and the observed Statement patterns that support each Kind.

Alignment — Information layer

The Alignment Agent compares the aggregated profiles. It performs structural matching, identity resolution, link completion, dimensional ordering and relational analogy discovery. Set inclusion, FCA, CPPE and clustering may contribute evidence for compatible Contexts, specialized ContextKinds or candidate Previous–Current–Next relationships.

Outputs may include Rule Statements describing aligned Contexts, source and destination Roles, cross-system links, dimensional constraints and candidate state transitions.

Activation — Knowledge layer

The Activation Agent uses aligned Contextual Rules to identify executable business situations. It can compose related Contexts into higher-level Use Cases, bind Roles to Actors and expose Interactions corresponding to meaningful operations or state transitions.

For example, a sequence of order placement, invoicing and shipment Contexts may support an OrderFulfillment Context. Activation can then expose a unified fulfillment Interaction whose execution coordinates the appropriate operations across CRM, ERP and warehouse systems.

Activation should consume validated rules and preserve any unresolved conditions. A ContextKind profile alone describes structural possibilities; executable behavior additionally requires sufficient information about Actors, applicable constraints, required state, execution order and side effects.

#### 7\. Illustrative Use Cases {#7.-illustrative-use-cases}

A. Cross-application order fulfillment

Suppose CRM, ERP and a warehouse system each expose Contextual Statements about an order. Aggregation identifies order, invoice and shipment Kinds. Alignment resolves the order's identity across the applications and compares the dimensional profiles of its placement, invoicing and shipment Contexts. Where explicit references and temporal or workflow evidence support the sequence, the framework materializes the corresponding ordering and dependency Statements.

The resulting Contextual model can expose an integrated order view and an OrderFulfillment Interaction, while retaining links to the underlying Statements and application resources.

B. Employee lifecycle and organizational context

Employment Contexts may include employee identity, employer, position, department and effective dates. Comparing these Contexts can reveal common employee structures and distinguish current assignments from historical ones. When reliable dates or versioned records are available, the framework can infer a position's Previous–Current–Next progression.

This supports employee lifecycle navigation, assignment-history queries, department membership and candidate HR interactions. Structural similarity between employment records does not, by itself, establish that two employee identities are the same or that an observed sequence is a valid organizational transition.

C. Cross-domain relational analogy

An employment Context may describe an Employee related to an Employer through a WorkRelationship. An academic Context may describe a Student related to a School through a StudentshipRelationship.

The framework can compare their SubjectKinds, PredicateKinds and ObjectKinds and infer a structural analogy between the relationships. This may support cross-domain schema alignment, shared high-level relationship categories and reusable query or workflow patterns without merging Employee with Student or Employer with School.

D. Event and state-transition discovery

Successive Contextual profiles for an order, account or employee can reveal changes in status, ownership, position or other properties. The framework may compare profiles, detect the appearance or disappearance of dimensions, and propose a state-transition rule.

Where the source data explicitly establishes event order and state changes, the transition can be materialized and used to identify the next available Interaction. Where ordering or causality is uncertain, the output should remain a candidate inference for validation.

E. Context-aware discovery and navigation

A client may request all Contexts matching a particular ContextKind, all Statements concerning a Resource in a particular business scope, or all Interactions whose prerequisites are satisfied. ContextKind memberships and indexed dimensional relations provide the basis for resolving such requests.

The resulting API can expose contextual resource relationships, parent and child Contexts, previous and next states, relevant Actors, and available Interactions. This makes the inferred dimensional graph useful both for read-oriented discovery and for navigating executable Use Cases.

#### 8\. Inference Materialization and Provenance {#8.-inference-materialization-and-provenance}

Inferred dimensional relationships should be represented as ordinary Resources, Occurrences and Statements rather than existing only as transient algorithm results. This allows the same merge, fold and unfold operations to process observed and inferred structures throughout the augmentation pipeline.

Each inferred Statement should preserve, directly or through associated metadata, at least:

* The supporting source Statements and their datasource provenance.  
* The Contexts and Kinds used in the inference.  
* The inference mechanism or applicable rule.  
* Whether the result is observed, deterministically derived, or probabilistically proposed.  
* Confidence or validation status where applicable.  
* The relevant temporal scope or version, when the conclusion depends on time.  
* Any constraints or assumptions required to interpret the relation.

An update to a source Statement should trigger recomputation or invalidation of dependent dimensional inferences. This avoids retaining stale Context classifications, ordering relations or workflow possibilities after the underlying graph changes.

The framework should also distinguish an unknown value from an absent value and an explicitly false assertion. Incomplete observations, closed-world assumptions, cardinality constraints and event-history retention can materially affect the interpretation of missing Statements.

#### 9\. Resulting Principle {#9.-resulting-principle}

Contextual Dimensional Analysis provides the bridge between individual CSPO Statements and higher-order contextual knowledge.

At the instance level, Contexts group and scope observed Statements. At the structural level, ContextKinds aggregate the recurring relationships among Subjects, Predicates and Objects. At the alignment level, comparisons between dimensional profiles support classification, specialization, correspondence, ordering and candidate relationship discovery. At the activation level, validated contextual relationships provide the foundation for executable Roles, Actors, Interactions and composite Use Cases.

The central principle is that dimensional structure is both descriptive and inferential: it describes the statements that occur within a Context and supplies the features from which additional semantic relationships may be discovered. Those relationships become persistent knowledge only when materialized as Statements with appropriate evidence, provenance and contextual meaning.

The resulting graph supports contextual retrieval and grouping, structural and temporal navigation, cross-application integration, state-transition tracking, constraint checking and dynamic Use Case discovery, while keeping inferred knowledge connected to the source data and the augmentation pipeline that produced it.

# Base Model Representations {#base-model-representations}

Base Model class hierarchy is represented by different meta model approaches (kept in sync with each other) for leveraging the most appropriate inference mechanisms.

Models persistence Monadic wrapper bound Base Model Entities (Resource, Occurrence, Statement, Context, Subject, Predicate, Object, Kind, ContextKind, SubjectKind, PredicateKind, ObjectKind) Functional APIs Definitions for stream processing.

The Base Model is represented simultaneously through several complementary meta-models. These representations are not competing alternatives; they are projections of the same `Resource → Occurrence → Statement → Kind` model, each optimized for particular forms of persistence, traversal, inference, comparison, aggregation, or stream processing.

Representations participate in the same **merge / fold / unfold** Augmentation pipeline (see “Execution Model”). One semantic model, multiple computational lenses.

## RDF Model Representation {#rdf-model-representation}

**RDF Model Representation:** This acts as the foundational raw data layer, utilizing a raw RDF Statements Triple (Quad) Store and a SPARQL Endpoint. It directly supports the objective by providing the standard graph representation and querying mechanism for the input and output streams of the semantic augmentation pipeline.

**Role in the whole objective**

* **Input:** natural representation for raw datasource statements.  
* **Aggregation:** expose CSPO structure so occurrences can be grouped into `ContextKind`, `SubjectKind`, `PredicateKind`, and `ObjectKind`.  
* **Alignment:** provide graph patterns, identity links, and relationship traversal.  
* **Activation:** provide the graph substrate from which contexts, roles, actors, and interactions can be materialized.  
* **Persistence/interoperability:** retain compatibility with RDF-oriented datasources and query infrastructure.

## Sets Based Model Representation {#sets-based-model-representation}

**Sets Based Model Representation:** This representation organizes data into Universal Sets (Contexts, Subjects, Predicates, Objects) and Kinds Sets derived from their intersections and unions. It leverages the framework's objective by treating data streams as mathematical collections, enabling deterministic operations for exact-match aggregations and deduplication.

**Role in the whole objective**

* **Aggregation:** unions/intersections provide deterministic grouping and exact-match type extraction.  
* **Alignment:** set equality, intersection, inclusion, and difference provide basic matching and compatibility operations.  
* **Activation:** sets can represent candidate states, possible transitions, or collections of executable structures before they are materialized as Statements.  
* **Pipeline:** set operations can act as low-level primitives underneath higher-level merge/fold/unfold operations.

Contexts Set: Context Dimensional Point Set.

Subjects Set.

Predicates Set.

Objects Set.

Context (Statements) Set: (Subject Set, Predicate Set, Object Set intersection).

Subject Kinds Set (Predicates Set intersection with Objects Set).

Predicate Kinds Set (Subjects Set intersection with Objects Set).

Object Kinds Set (Subjects Set intersection with Predicates Set).

![][image4]

### Sets layout for Dimensional Analysis {#sets-layout-for-dimensional-analysis}

See: “Context’s ContextKind(s) Dimensional Roles”

The above Sets Layout diagram represents the structure of the placeholders for a snapshot of the Resources occurrences in their corresponding Roles for a given Context Dimensional Point (Context’s axes Statements).

Contexts (Statements: SPO Intersection) represents all the possible Statements for an aggregated Context dimensional point. All possible Dimension Point Kinds (SK, PK, OK) are then aggregated. Then all SPO Resource Occurrences are assigned to their corresponding Roles.  

TODO: Encode Context Statements. Resolve Context Statements SPO Statements.  
TODO: Refactor Base Model for CSPO Contexts representing Dimensional Aggregation Points (axes Statements): ContextKind\<Subject, Predicate, Object\>.  
TODO: Inference through Sets based operations.  
TODO: Reify Kinds as SPO Resource Occurrences.

The Sets Layout diagram represents the dimensional structure of a Context as a bounded scope containing overlapping Subject, Predicate and Object dimensions. It describes the Resources and Occurrences participating in a snapshot of the Statement graph, together with the possible Kind classifications and relationships inferred from those occurrences.

The outer Context boundary represents the scope in which a set of Statements is interpreted. The Subject, Predicate and Object circles represent the three principal dimensions of those Statements. Their overlap regions represent the dimensional relationships from which SubjectKinds, PredicateKinds, ObjectKinds and ContextKinds can be aggregated or inferred.

The diagram is a conceptual representation of dimensional compatibility. Since Subjects, Predicates and Objects are distinct typed Resource collections, their identifiers should not necessarily be interpreted as members of the same literal mathematical set. In an executable model, the overlaps are implemented through typed occurrence representations, Statement membership, relational joins and comparisons of normalized dimensional features.

The central principle is that set operations provide deterministic structural evidence from which Kinds, Context relationships, schema patterns and candidate state transitions can be inferred. These operations provide a foundation for the Aggregation and Alignment stages and prepare candidate states and interactions for Activation.

#### 1\. Formalizing the Sets Layout {#1.-formalizing-the-sets-layout}

For a Context C, define the following collections of Resources occurring in its Statements:

* ![S\_C][image5]: the set of distinct Subject Resources occurring in C.  
* ![P\_C][image6]: the set of distinct Predicate Resources occurring in C.  
* ![O\_C][image7]: the set of distinct Object Resources occurring in C.  
* ![Q\_C][image8]: the set of distinct observed Subject–Predicate–Object tuples scoped by C.

The observed Statement set satisfies:

![Rendered mathematical expression: Q\_C \\subseteq S\_C \\times P\_C \\times O\_C][image9]

The Cartesian product represents the candidate combinations of the three dimensions; ![Q\_C][image10] contains only the combinations actually observed as Statements. Domain constraints, range constraints, Kind membership and contextual rules may further restrict which candidate combinations are valid.

This distinction is essential. The fact that a Subject, Predicate and Object occur in the same Context does not mean that every possible combination of those Resources is an observed or valid Statement.

For example, a sales Context might contain:

(:CustomerA, :placesOrder, :Order101)

(:CustomerA, :placesOrder, :Order102)

(:Order101, :hasStatus, :Pending)

Its corresponding sets contain the distinct Subjects, Predicates and Objects occurring in these Statements, while its Statement set preserves their actual combinations. A set of dimension members alone would not retain all the relationship information encoded in the original Statements.

The Context's ContextKind can then be derived from the observed dimensional structure:

![Rendered mathematical expression: \\Phi(C)=\\{(SK(s),PK(p),OK(o))\\mid(s,p,o)\\in Q\_C\\}][image11]

Here, ![SK(s)][image12], ![PK(p)][image13] and ![OK(o)][image14] denote the applicable SubjectKind, PredicateKind and ObjectKind classifications. Where Kind membership has not yet been established, the corresponding instance-level Resources can be retained until the Aggregation stage derives or validates those classifications.

This profile is a conceptual representation of the dimensional structure aggregated by a ContextKind. The underlying model still materializes the result using the existing Context, Subject, Predicate and Object roles.

Kinds as dimensional projections

Each dimension provides a distinct perspective over the same Statement set:

* SubjectKind: groups Subjects by their observed Predicate and Object patterns.  
* PredicateKind: groups Predicates by their observed Subject and Object patterns.  
* ObjectKind: groups Objects by their observed Subject and Predicate patterns.  
* ContextKind: aggregates the dimensional patterns of the Context as a whole.

These perspectives should be computed from the same normalized Statement graph, preserving each Resource's identity, occurrence Role and Context. They are complementary projections, not independent datasets.

The existing Sets Layout notation can consequently be interpreted as follows:

| Dimensional projection | Structural features aggregated | Possible inference |
| ----- | ----- | ----- |
| Context | Observed Subject–Predicate–Object tuples | ContextKind classification and Context comparison |
| Subject | Predicates and Objects associated with a Subject | SubjectKind, common attributes and specialization candidates |
| Predicate | Subjects and Objects associated with a Predicate | PredicateKind, domain/range patterns and relationship classification |
| Object | Subjects and Predicates associated with an Object | ObjectKind, value classification and inverse relationship patterns |
| Context and Kind combinations | Compatible dimensional signatures | Structural matching, schema inference and candidate Rule Statements |

The diagram's overlapping regions are therefore an intuitive representation of shared dimensional features and compatible roles. The operational semantics are supplied by the typed collections and the Statement relationships connecting them.

#### 2\. Fundamental Set Operations {#2.-fundamental-set-operations}

The model can use union, intersection, relative difference, inclusion and compatibility operations over its Resource, Occurrence, Statement and Kind collections. These operations have different meanings depending on whether they are applied to actual Statements, entity identifiers, normalized feature sets or inferred Kind memberships.

2.1 Union — aggregation and consolidation

For two Contexts ![C\_1][image15] and ![C\_2][image16]:

![Rendered mathematical expression: Q\_{C\_1\\cup C\_2}=Q\_{C\_1}\\cup Q\_{C\_2}][image17]

Union collects distinct Statements from both sets. Equivalent operations can combine their Subject, Predicate and Object collections, while retaining the information needed to identify each Statement's original Context and provenance.

Possible inferences and use cases:

* Aggregate records from multiple datasource streams into a larger analytical collection.  
* Construct a combined dimensional profile from related Contexts.  
* Discover the complete set of attributes and relationships observed across multiple instances.  
* Infer shared or generalized Kinds from recurring patterns.  
* Build an integrated read view for an entity whose information is distributed across different applications.

For example, CRM may contribute customer and order-placement Statements, while ERP contributes order and invoice Statements. Their union provides the combined observations needed to infer a wider order-related ContextKind.

Union alone does not resolve conflicting identities. If the two systems use different identifiers for the same order, the Alignment stage must establish the correspondence before the Resources can be consolidated as one semantic entity.

2.2 Intersection — commonality and shared structure

The intersection of two Statement sets is:

![Rendered mathematical expression: Q\_{C\_1}\\cap Q\_{C\_2}][image18]

It contains Statements that are identical under the chosen identity and normalization rules.

Intersections of dimensional feature sets can similarly identify shared Predicates, values, Kind memberships or relationship signatures.

Possible inferences and use cases:

* Find common properties or relationships across Contexts.  
* Identify recurring Statement patterns that characterize a Kind.  
* Compare the common information exposed by two applications.  
* Recognize exact duplicate Statements when identifiers and statement identity are normalized.  
* Derive common structural signatures for further FCA-based concept inference.  
* Find the set of capabilities, attributes or prerequisites shared by multiple candidate workflows.

For example, if two employee Contexts both contain an employer relationship and a position property, their common dimensional features may support the inference that they belong to a shared employment-related class.

Common features establish structural similarity, not necessarily identity. Two different employees may have identical attribute sets, and two different Contexts may have the same Statement pattern while describing separate business events.

2.3 Relative difference — identifying additions, omissions and divergence

For two sets ![A][image19] and ![B][image20], the relative difference ![A\\setminus B][image21] contains the elements present in ![A][image22] but absent from ![B][image23].

For Contexts, this gives:

![Rendered mathematical expression: Q\_{\\text{added}}=Q\_{C\_2}\\setminus Q\_{C\_1}][image24]

![Rendered mathematical expression: Q\_{\\text{removed}}=Q\_{C\_1}\\setminus Q\_{C\_2}][image25]

Possible inferences and use cases:

* Identify attributes or relationships available in one datasource but not another.  
* Detect changes between two Context snapshots.  
* Find source-specific information that should be retained during integration.  
* Identify missing expected relationships, once a rule or reference profile establishes what is expected.  
* Detect schema drift, unexpected property additions or inconsistent representations.  
* Explain why two Contexts fail to match by enumerating their differing features.

Difference can be particularly useful during Alignment. Rather than only reporting that two Contexts do not match, the framework can identify the particular dimensional features responsible for the mismatch.

A missing member of a Statement set is not, by itself, evidence of missing or erroneous data. It may indicate that the Statement is unknown, unavailable from that datasource, outside the Context's scope or legitimately absent. The interpretation depends on the expected schema, source coverage and applicable constraints.

2.4 Inclusion and subset — specialization and hierarchy

For sets ![A][image26] and ![B][image27]:

![Rendered mathematical expression: A\\subseteq B][image28]

means every member of ![A][image29] also belongs to ![B][image30]. Strict inclusion holds when ![A\\subseteq B][image31] and ![A\\neq B][image32].

Applied to normalized feature sets, inclusion can identify a more general structural profile and another profile containing additional dimensions.

For example, let:

![Rendered mathematical expression: F\_{\\text{basic}}=\\{\\text{name},\\text{employer}\\}][image33]

![Rendered mathematical expression: F\_{\\text{extended}}=\\{\\text{name},\\text{employer},\\text{position},\\text{department}\\}][image34]

Then:

![Rendered mathematical expression: F\_{\\text{basic}}\\subset F\_{\\text{extended}}][image35]

The second profile extends the first with additional attributes. This can support a specialization or extension hypothesis.

Possible inferences and use cases:

* Infer candidate Kind hierarchies from attribute inclusion.  
* Identify a ContextKind that is a specialization of a more general ContextKind.  
* Discover entities that conform to a minimum structural contract while exposing extra properties.  
* Compare API schemas and identify backward-compatible extensions.  
* Identify shared prerequisites and additional requirements in process stages.  
* Construct a partial ordering over normalized dimensional profiles.

Inclusion should be applied to compatible features within an explicitly defined scope. A more extensive observed profile does not automatically establish temporal precedence, subclassing or business importance. Such interpretations require corresponding semantic rules or additional evidence.

2.5 Equality — exact structural matching

If two normalized feature sets are equal, then:

![Rendered mathematical expression: A=B\\iff A\\subseteq B\\land B\\subseteq A][image36]

Set equality enables deterministic tests for whether two profiles contain exactly the same members.

Possible inferences and use cases:

* Detect identical normalized Statement collections.  
* Find Contexts with matching dimensional signatures.  
* Compare source schema definitions.  
* Recognize exact duplicate Kind definitions.  
* Test whether a resource representation conforms to a specified structural profile.

Exact profile equality does not imply that the underlying Resources or events have the same identity. The framework should distinguish identical structure, equivalent meaning and identical real-world entity.

2.6 Symmetric difference — measuring structural divergence

The symmetric difference is:

![Rendered mathematical expression: A\\triangle B=(A\\setminus B)\\cup(B\\setminus A)][image37]

It contains elements present in either set but not both.

Possible inferences and use cases:

* Measure the structural differences between two versions of a Context.  
* Rank candidate schema matches by the number or importance of differing features.  
* Identify changes introduced by a datasource update.  
* Compare the completeness of source representations.  
* Trigger further Alignment processing when previously matching profiles diverge.

For unordered, normalized sets, symmetric difference provides an exact measure of membership disagreement. It does not account for semantic importance or the relative cost of different mismatches unless additional weights or rules are supplied.

2.7 Cartesian product and constrained combinations — candidate Statement discovery

The Cartesian product:

![Rendered mathematical expression: S\_C\\times P\_C\\times O\_C][image38]

enumerates candidate combinations across the three dimensions. The observed Statement set ![Q\_C][image39] is a subset of that product.

Applying domain, range, Kind and contextual constraints can narrow the product to combinations eligible for further analysis.

Possible inferences and use cases:

* Discover candidate Statements that satisfy an inferred relationship pattern.  
* Identify possible links between Resources that share compatible dimensional Roles.  
* Generate candidate schema mappings for Alignment.  
* Find potential workflow transitions from a set of valid states and interactions.  
* Search for combinations that satisfy explicit prerequisites.

The Cartesian product can grow rapidly as the number of Resources increases. Practical implementations should use selective joins, indexed Statement lookups, Kind restrictions and other pruning mechanisms instead of blindly materializing every combination.

Generated combinations remain candidates until supported by observations or accepted rules. A possible Statement must not be treated as a factual Statement merely because its Subject, Predicate and Object occur somewhere in the same Context.

2.8 Power sets — discovering attribute combinations

The power set ![\\mathcal{P}(F)][image40] of a finite feature set ![F][image41] contains all possible subsets of ![F][image42]. Attribute subsets can be used to discover recurring signatures and candidate generalizations.

Possible inferences and use cases:

* Find common attribute combinations associated with a Kind.  
* Infer more general and more specialized dimensional profiles.  
* Identify minimal sets of attributes that distinguish one Context class from another.  
* Discover schema archetypes for FCA analysis.  
* Generate candidate classifications for previously unseen Contexts.

Because a set of ![n][image43] distinct features has ![2^n][image44] subsets, exhaustive power-set generation may be impractical for large feature collections. Implementations should restrict the search using frequency thresholds, domain constraints, maximal or closed patterns, or incremental inference.

#### 3\. Deriving Kinds from Dimensional Sets {#3.-deriving-kinds-from-dimensional-sets}

The primary purpose of the Sets Layout is to make the dimensional relationships of Contexts and their participating Resources available for structured inference.

For a Subject ![s][image45] in Context ![C][image46], define its observed feature set as:

![Rendered mathematical expression: F\_S(s,C)=\\{(p,o)\\mid(s,p,o)\\in Q\_C\\}][image47]

Likewise, for a Predicate ![p][image48]:

![Rendered mathematical expression: F\_P(p,C)=\\{(s,o)\\mid(s,p,o)\\in Q\_C\\}][image49]

And for an Object ![o][image50]:

![Rendered mathematical expression: F\_O(o,C)=\\{(s,p)\\mid(s,p,o)\\in Q\_C\\}][image51]

These are example structural projections of the observed Statements. They preserve the relationship combinations needed to distinguish simple co-occurrence from actual dimensional patterns.

They support the existing Kind definitions as follows:

* SubjectKind inference: group Subjects with compatible Predicate–Object patterns.  
* PredicateKind inference: group Predicates with compatible Subject–Object patterns.  
* ObjectKind inference: group Objects with compatible Subject–Predicate patterns.  
* ContextKind inference: aggregate the dimensional profiles of Statements and the applicable Kinds in a Context.

Two feature sets may be exactly equal, share a subset or have only a partial overlap. Each outcome supports a different inference:

| Feature comparison | Possible interpretation | Use case |
| ----- | ----- | ----- |
| Equal feature sets | Exact structural equivalence at the selected level | Duplicate schema or profile detection |
| Large shared intersection | Common structural characteristics | Candidate Kind classification |
| One feature set is a subset of another | Possible specialization or extension | Kind hierarchy and schema evolution |
| Small intersection with substantial difference | Weak structural correspondence | Reject or deprioritize an Alignment candidate |
| New features appear in successive snapshots | Change in observed dimensions | Resource update or state-change analysis |
| A required feature is absent | Potential constraint violation or incomplete representation | Data-quality and workflow validation |

These comparisons are deterministic when the sets are constructed from normalized data. The semantic interpretations remain dependent on the rules under which those comparisons are applied.

For example, two Subjects with the same set of observed properties may be structurally equivalent for a particular inference task, but may represent different real-world entities. If the compared properties include only names and employers, the profiles may be too weak to support identity resolution.

Kind classification should therefore consider the selected Context, the relevant feature dimensions, applicable cardinality constraints and any additional identifiers or evidence required by the domain.

#### 4\. Comparing Contexts and Inferring Dimensional Relationships {#4.-comparing-contexts-and-inferring-dimensional-relationships}

Each Context can be represented by multiple comparable sets:

* The set of observed Statements.  
* The sets of participating Subjects, Predicates and Objects.  
* The sets of their Kind memberships.  
* The set of normalized dimensional signatures.  
* The set of explicitly defined constraints and expected relationships, where available.

Comparing these sets allows the framework to discover several classes of relationship.

4.1 Equivalent Context profiles

When two Contexts have identical normalized dimensional profiles, the framework can materialize an exact profile-equivalence result, such as:

(:ContextA, :hasSameDimensionalProfileAs, :ContextB)

This is useful for grouping equivalent schema structures, recognizing repeated event patterns and identifying Contexts eligible for a common ContextKind.

Profile equivalence must remain distinct from Context identity. Whether two Contexts can be merged requires additional identity evidence, compatible scope and preservation of their distinct provenance.

4.2 Context specialization and extension

If one dimensional feature set is included in another, the framework can identify a candidate specialization relationship:

(:ExtendedContextKind, :extends, :BasicContextKind)

This supports schema hierarchies, discovery of specialized business situations and compatibility analysis between API representations.

The hierarchy should be based on comparable, normalized feature sets. Missing observations in a sparse source may make an entity appear structurally more general than it really is; completeness assumptions and source coverage must therefore be considered.

4.3 Cross-application structural correspondence

Suppose a CRM Context contains customer and order relationships, while an ERP Context contains order and invoice relationships. Their Statement sets may have few exact members in common because their applications use different identifiers and predicates.

Their normalized Kind-feature sets may nevertheless reveal a common order-related structure.

The framework can use the shared features to generate candidate mappings, then apply Alignment mechanisms to resolve entity identities, map corresponding Predicates and complete supported links.

This permits semantic integration without requiring that two independent application schemas be identical.

4.4 Dimensional ordering and state-transition candidates

Set differences can compare successive snapshots of a Resource or Context.

Let ![Q\_t][image52] represent the observed Statement set at time ![t][image53], and ![Q\_{t+1}][image54] the subsequent snapshot:

![Rendered mathematical expression: Q\_{\\text{unchanged}}=Q\_t\\cap Q\_{t+1}][image55]

![Rendered mathematical expression: Q\_{\\text{added}}=Q\_{t+1}\\setminus Q\_t][image56]

![Rendered mathematical expression: Q\_{\\text{removed}}=Q\_t\\setminus Q\_{t+1}][image57]

These sets distinguish unchanged information, new observations and observations no longer present in the later snapshot.

For example, an employee's position may change from :Engineer to :Manager. Comparing the two profiles can reveal the addition of the manager position and removal of the engineer position from the current-state representation.

If reliable temporal, version or event evidence is available, the framework can use the differences to infer a candidate state transition and materialize relationships such as:

(:PreviousEmploymentState, :next, :CurrentEmploymentState)

Set difference alone does not establish that one Context occurred before another or that an event caused the change. Temporal ordering and causal interpretation require additional evidence or explicit business rules.

#### 5\. Possible Inferences and Use Cases Based on Set Operations {#5.-possible-inferences-and-use-cases-based-on-set-operations}

The following use cases describe how the Sets Layout can contribute to the broader Aggregation, Alignment and Activation pipeline.

5.1 Schema and Kind discovery

Aggregate feature sets from observed Statements and group Resources with recurring dimensional patterns. Intersections identify shared characteristics; inclusion identifies possible extensions; differences reveal distinguishing attributes.

This can support:

* Discovering SubjectKinds, PredicateKinds and ObjectKinds.  
* Inferring ContextKinds from recurring Statement signatures.  
* Identifying general and specialized schema patterns.  
* Discovering fields that commonly appear together.  
* Identifying attributes that distinguish one Kind from another.  
* Finding candidate schema archetypes for subsequent FCA inference.

For example, if multiple order-related Contexts exhibit customer, order-status and order-item patterns, the Aggregation stage can identify common order-related structures without requiring an application-specific schema to be declared in advance.

5.2 Deduplication and source reconciliation

Unions and intersections can identify repeated observations and compare records across data sources.

This can support:

* Deduplicating repeated canonical Statements.  
* Identifying identical normalized schema definitions.  
* Comparing attributes supplied by multiple applications.  
* Preserving source-specific assertions while constructing combined views.  
* Finding conflicts where the same canonical Resource has different reported values.

Deduplication must use an explicit definition of Statement identity, including Context scope where relevant. Equal values or equal feature sets are insufficient to merge distinct Resources automatically.

5.3 Cross-application identity and semantic Alignment

For two candidate entities, compare their normalized attribute and relationship sets. Their shared features and differences can generate evidence for an identity or mapping decision.

For example, a CRM Customer and a Billing Account may have shared external identifiers, addresses and customer relationships. A high level of structural overlap can prioritize them as a candidate match.

The Alignment stage should combine this evidence with deterministic identifiers, contextual compatibility, cardinality constraints and provenance before asserting a merged identity. Set similarity is a matching signal, not a universal identity test.

5.4 Missing-link and completeness detection

Where an explicit schema or Rule Statement establishes that a particular relationship is required, the expected feature set can be compared with the actual Statement set.

Let ![E\_C][image58] represent the Statements or normalized relationship patterns expected under a specified rule for Context ![C][image59]. Then:

![Rendered mathematical expression: Q\_{\\text{candidate missing}}=E\_C\\setminus Q\_C][image60]

This identifies expected patterns absent from the current observed representation.

Possible use cases include detecting an order without a required customer reference, an invoice without an expected order link, or a fulfillment Context without the tracking information required by a particular workflow.

The output is a candidate discrepancy. It becomes a confirmed violation only when the rule applies, the data is expected to be complete, and the source's scope and update status justify that conclusion.

5.5 Schema evolution and change detection

Compare Statement and feature sets across source snapshots or schema versions.

Possible use cases include:

* Identifying newly introduced predicates or value types.  
* Detecting removed fields and relationships.  
* Finding incompatible schema changes.  
* Identifying additional dimensions introduced by an application upgrade.  
* Determining which inferred Kinds or Rule Statements may need to be recomputed.  
* Producing change summaries for downstream consumers.

Symmetric differences can help localize structural changes, while inclusion tests can determine whether a schema has expanded or contracted under a consistent representation.

5.6 Context-aware queries and retrieval

Set membership and intersections provide the basis for retrieving Resources and Statements by their dimensional features.

Possible queries include:

* Return all Contexts containing a given SubjectKind and PredicateKind.  
* Find all Statements shared by two specified Contexts.  
* Retrieve the relationships present in one datasource but not another.  
* Find Contexts that extend a specified dimensional profile.  
* Identify the statements supporting a particular Kind assignment.  
* Return Resources whose feature sets satisfy a specified set of conditions.

These operations can support efficient read-facade endpoints and contextual navigation without requiring clients to know each underlying application's data structure.

5.7 State and workflow discovery

Set comparisons can provide the structural features used to identify candidate states and transitions.

For example, differences between successive order profiles might show the appearance of an invoice relationship and then a shipment relationship. When aligned with reliable events and applicable business rules, these patterns can support a sequence such as:

OrderPlaced → OrderInvoiced → OrderShipped

Possible use cases include lifecycle visualization, identifying the next permissible Interaction, finding recurring process paths and detecting unexpected state changes.

The existence of a set of observed changes is not by itself sufficient to establish a valid workflow. Activation must also consider execution prerequisites, Actor availability, permitted state transitions and any cross-application side effects.

5.8 Constraint checking and anomaly detection

Known valid feature sets or Rule Statements can be compared against observed sets.

Possible use cases include:

* Detecting unexpected combinations of Kinds.  
* Finding Resources missing mandatory attributes.  
* Identifying values outside an allowed range or set.  
* Detecting contradictory source representations.  
* Identifying Contexts that diverge from their expected structural profiles.  
* Selecting anomalous records for further Alignment or validation.

Deterministic set comparisons work well for explicit constraints. Statistical anomaly detection or semantic classification may be needed when acceptable variation cannot be expressed as a finite set of explicit rules.

5.9 Candidate relationship and interaction discovery

The set of possible dimensional combinations can be constrained by observed Kinds, applicable Rules and relationship signatures to find candidate links and actions.

For example, a known order-related ContextKind may imply that a fulfillment workflow operates over Orders, Invoices and Shipments. If the current Context satisfies the prerequisites for a particular Interaction, the system can expose it as an eligible candidate.

This supports the discovery of composite Use Cases and potential operations spanning multiple applications.

The candidate set must be validated by the Activation layer before it becomes an executable Interaction. Structural compatibility alone does not establish authorization, operational readiness or safe execution.

#### 6\. Integration into the Augmentation Pipeline {#6.-integration-into-the-augmentation-pipeline}

Set operations play complementary roles in the three stages of semantic augmentation.

Aggregation — structural extraction

The Aggregation Agent computes sets of observed Statement components, groups occurrences by common features and derives candidate Kinds from exact commonality and compatible structure.

Typical outputs include Property Statements representing ContextKinds, SubjectKinds, PredicateKinds and ObjectKinds, together with the observed evidence supporting their definitions.

Alignment — semantic comparison

The Alignment Agent compares the resulting profiles by equality, intersection, inclusion and difference. It uses those comparisons to find candidate correspondences, schema extensions, relationship mappings, identity matches and dimensional ordering.

Possible results are materialized as Rule Statements that describe the validated or candidate relationships between resources and Kinds. Probabilistic or unresolved matches should remain distinguishable from deterministic, validated correspondences.

Activation — candidate behavior and state transitions

The Activation Agent uses aligned structures, contextual constraints and observed state changes to construct candidate execution structures. Set membership and feature comparison help identify eligible Contexts, participating Roles, Actors and Interactions.

The pipeline can then materialize executable Context production Statements, for example:

(DCIContextCK, RoleSK, ActorPK, InteractionOK)

The set representation helps establish which structures are present or compatible. The Activation rules establish whether those structures form a valid executable behavior.

#### 7\. Materialization, Provenance and Incremental Recalculation {#7.-materialization,-provenance-and-incremental-recalculation}

Set operations are deterministic only with respect to the sets and equivalence rules supplied to them. Correct semantic inference also requires careful treatment of identity, Context scope, provenance and data completeness.

Each inferred relationship should retain a trace to the observations and rules that support it. Depending on the inference, this may include:

* The source Statements contributing to the set operation.  
* The Context and Kind profiles compared.  
* The normalization and identity-resolution rules applied.  
* The exact operation used, such as intersection, inclusion or relative difference.  
* The resulting classification, relationship or candidate state transition.  
* The relevant datasource provenance, temporal scope and validation status.

When a source Statement is added, updated or removed, the framework should recalculate affected dimensional sets and invalidate dependent inferences where necessary. Stream-oriented merge, fold and unfold provide the mechanisms for propagating these changes through the Aggregation, Alignment and Activation layers.

Several implementation considerations are especially important:

* Set versus multiset: ordinary sets remove duplicates and do not retain frequency. Where occurrence counts, repeated events or frequency-based confidence matter, the model must retain counts or occurrence records alongside set membership.  
* Open versus closed world: absence from an observed set means that the Statement was not observed in that collection; it does not automatically mean the Statement is false.  
* Identity normalization: intersections across sources are meaningful only after defining which identifiers and representations count as equivalent.  
* Context scope: identical SPO tuples in different Contexts may represent separate assertions, times, sources or situations. Context boundaries and provenance must be preserved.  
* Inference complexity: exhaustive Cartesian products and power sets can grow rapidly. Indexed joins, incremental set updates and selective candidate generation are needed for larger graphs.  
* Semantic interpretation: inclusion indicates structural extension under the chosen representation, but does not independently establish subclassing, chronology, causation or business precedence.

#### 8\. Resulting Principle {#8.-resulting-principle}

The Sets Layout for Dimensional Analysis establishes a deterministic algebra over the Resources, Occurrences, Statements and Kinds participating in a Context. It turns raw Statement collections into comparable dimensional profiles, allowing structural commonality, difference, inclusion, candidate completeness and change to be computed explicitly.

The resulting inferences support Kind discovery, Context classification, schema comparison, cross-application Alignment, missing-link detection, lifecycle analysis, contextual querying and candidate Use Case discovery.

The central principle is that set operations reveal structural facts about the represented collections, while semantic rules determine what those facts mean. Materializing the resulting conclusions as traceable Statements allows those conclusions to be reused by the same augmentation pipeline that produced them.

In this way, the Sets Layout becomes more than a diagram of overlapping dimensions. It provides the mathematical foundation for deriving, comparing, validating and incrementally maintaining the contextual structures upon which the framework's unified resource and interaction facade depends.

## ISO TMRM Model Representation {#iso-tmrm-model-representation}

**ISO TMRM Model Representation:** Operating as the underlying common metamodel, this maps the base entities onto TMRM subject proxies and properties. It supports the core objective by providing a subject-centric, implementation-independent foundation that drives deterministic identity resolution and topic merging across disparate data streams.

**Role in the whole objective**

* Provides the **subject-centric semantic substrate** for Resources and their contextual Occurrences.  
* Preserves identity and context while navigating statements.  
* Supports resource merging and graph traversal.  
* Gives higher-level inference mechanisms a stable semantic model to operate on.

RDF provides the graph syntax; TMRM provides the semantic metamodel through which that graph can be manipulated as contextual subjects, occurrences, and statements.

## FCA Context Lattices Model Representation {#fca-context-lattices-model-representation}

**FCA Context Lattices Model Representation:** This approach maps Contexts, Subjects, Predicates, and Objects into Formal Contexts. It advances the intelligence objective by allowing the system to build unified concept lattices, discovering implicit structural hierarchies, relational schemas, and classifications that are not immediately visible in isolated data streams.

The three FCA perspectives defined:

* **Subject as context:** predicates as objects, objects as attributes.  
* **Predicate as context:** subjects as objects, objects as attributes.  
* **Object as context:** subjects as objects, predicates as attributes.

**Role in the whole objective**

* **Aggregation:** infer recurring concepts, types, attributes, and shared properties.  
* **Alignment:** discover higher-level conceptual equivalences, structural correspondences, domains/ranges, and relational schemas.  
* **Activation:** use the inferred conceptual structures as the semantic basis for recognizing valid contexts and interactions.  
* **Materialization:** convert lattice concepts back into Kinds / Statements so inference becomes persistent knowledge rather than an isolated analytical result.

## XML Model Representation {#xml-model-representation}

TreeGraph for nested Statements structures and stream-processing messages.

**XML Model Representation:** This utilizes a TreeGraph format for handling nested Statements structures. It directly facilitates the execution model by defining the pipeline messages format, enabling the stream-oriented processing, folding, and unfolding of complex, layered message payloads across the augmentation agents.

**Role in the whole objective**

* Serialize a complete nested Statement/Kind structure into a single pipeline message.  
* Preserve the contextual structure needed for fold/unfold operations.  
* Support fan-in/fan-out asynchronous agent communication.  
* Carry inferred production Statements between Aggregation, Alignment, and Activation agents.

RDF / TMRM / FCA / Sets are primarily semantic/computational representations; XML is primarily a structural transport representation for the stream-processing model.

## Representations Summary {#representations-summary}

| Representation | Primary strength | Aggregation | Alignment | Activation | Stream/Persistence role |
| :---- | :---- | :---- | :---- | :---- | :---- |
| **RDF** | Graph interchange & querying | Source statement analysis | Graph pattern matching | Knowledge graph substrate | Persistent/source graph |
| **Sets** | Exact structural algebra | Group/intersect | Equality/inclusion/difference | Candidate collections/state sets | Computational primitive |
| **TMRM** | Semantic metamodel & identity | Contextual resource classification | Identity/merge/traversal | Context/role graph substrate | Semantic persistence |
| **FCA** | Concept/lattice inference | Type & attribute inference | Concept/schema matching | Conceptual context recognition | Inference state/materialization |
| **XML/TreeGraph** | Nested serialization | Carry folded structures | Carry aligned structures | Carry executable structures | Pipeline messaging |

The representations should remain semantically synchronized: an entity represented as a Resource/Occurrence/Statement in the Base Model can be projected into RDF triples/quads, set membership, TMRM subjects and occurrences, FCA contexts/concepts, or serialized TreeGraph messages without becoming a different semantic entity. Each projection exposes operations useful to a particular phase of the augmentation pipeline.

# Execution Model: Augmentation Agents Pipeline  {#execution-model:-augmentation-agents-pipeline}

A sequential message driven execution model, the Augmentation Pipeline, performs, by means of message exchange streams processing (unfolding, merging and folding), the Semantic Streams Augmentation of raw RDF CSPO URIs Quads input Statements (from configurable Datasources\*) into executable models of knowledge gathered by means of (1) Aggregation, (2) Alignment and (3) Activation of Statements (messages) encoding corresponding layers domain models Statement types structures.  

Augmentation Agents communicate with each other by means of a series of messaging endpoints where each layer consumes its input (source) Statements and publishes their output (production) Statements. Layers input and output Statements are of two types: an Augmentation Agent layer can consume both of their source Statements types and their production Statements types.

In the first case, processing a source Statement type input, it “merges” this input source type Statement with its source level type already known processed Statements aggregating, aligning and activating possible new inferred Statements. It then “folds” (aggregates) the resulting merged Statements into its layer corresponding Kind types Statements, then builds and produces its output production (Kinds) Statement types for production publishing.

In the case of a layer’s production Statement type as the consumed input, agents merges this input with its already known production statement types (matching / merging input Statement Kinds with already known Kinds), it then “unfolds” input Statement components (Kinds) into layer’s Kinds aggregated originating source type Statements obtaining this way the source Statement type Statements which originated the input (Kinds) production Statement message (source Statements). It then performs, with each “unfolded” Statement, the same way as if it were like those source Statements where consumed source Statements (merging, folding and publishing). Intermediate source type merged new inferred Statements are also merged, folded and published.

This Agent pipeline execution model could be depicted as:

source statements input / merge \-\> folding \-\> production statements merge and publishing

production statements input / merge \-\> unfold \-\> source statements merge and publishing

The merge steps in the pipeline is where new knowledge (Statements) are Aggregated, Aligned and Activated, where pipeline layers inference is performed materializing inferred knowledge into new Statements of each type. That is why it makes sense to merge new inputs with previous knowledge and inferred knowledge in a pipeline in / out fashion.

This fan in / fan out approach is intended to be implemented in a reactive functional streams pipeline where each agent consumes and produces knowledge asynchronously and in parallel. An Agent production type Statement is another Agent source type Statement (maybe including the Agent itself) and an Agent source type Statement is the type of another Agent production Statement type. An Agent “accepts” an Statement (source or production) if it is not known already or if it was further processed (updated) its context since the last consumption (or “acceptance” performance is no-op).

## Homoiconic (code as data) approach {#homoiconic-(code-as-data)-approach}

Messaging pipeline oriented resources consumption and publishing. Merge, Fold, Unfold phases functional approach.

Merging input data against previously known data, applying previously known data as a Template / Alignment / Transformation for merge over input data is what is meant with “code as data”.

Resources (Occurrences, Statements, Contexts, Subjects, Predicates, Objects and their corresponding Kinds) are “functional” entities that can be “applied” to another Resources. The signature of such functional composition is as follows (TODO):

Resource::apply(res: Resource) : Resource  
Resource::apply(res: Occurrence) : Resource  
Resource::apply(res: Statement) : Resource  
Resource::apply(res: Context) : Resource  
Resource::apply(res: Subject) : Resource  
Resource::apply(res: Predicate) : Resource  
Resource::apply(res: Object) : Resource  
Resource::apply(res: ContextKind) : Resource  
Resource::apply(res: SubjectKind) : Resource  
Resource::apply(res: PredicateKind) : Resource  
Resource::apply(res: ObjectKind) : Resource

Each Resource hierarchy class has their own overridden implementation of those ‘apply’ methods. The semantics of such “applications” (argument types and return types) are to be defined for each Resource type subclass implementing or overriding the corresponding ‘apply’ methods, their internal state and leveraging the following by means of Helper Services:

Apply as functional graph traversal by invocations compositions.

Kinds Functional Application.

FCA Inference / Traversal.

CPPE Contextual Inference.

Sets Model Representation.

Example: Kind applied to a Resource returns all Statements where the Resource is a player of the Kind.

Given a monadic wrapper (Spring Flux, Mono, for example) for handling streams processing:

aWrappedResource.map(aResourceInstance::apply) : Flux\<AResourceInstanceApplyType\>

Then, Resource(s) applications can be chained and combined by means of stream pipelines composition. 

**Kinds Functional Comprehensions:**

Kinds: extensional functions definitions. Functions Comprehensions: infer Kinds Functions from CPPE embeddings vía Helpers / ML. Resource Merge / Apply: Kinds inferred Functions inference.

**Monadic fold / unfold:** 

Aggregate (Kinds map / reduce):   
key (PlayerType), values (AttributeType, ValueType).

De aggregate: unfold to original Kind Statements (stream scan).

Merge: application of aggregated (folded) / de aggregated (unfolded) Resources to output / input streams (augmented with previous merge results) on each key (fold) aggregation completion and on each unfold stream scan emitted Resource.

TODO: Resource::apply Helpers Services approaches: FCA, CPPE, RDF inference, Sets, etc. ML Models / LLMs (classification : Aggregation, clustering : Alignment, regression : Activation). Unify Augmentation application Helper Services approaches APIs.

Data Structures (Folded Kinds):

\<Map\<Resource, Set\<Map\<Resource, Set\<Resource\>\>\>\>\>

\<Map\<Subject, Set\<Predicate\>\>  
\<Map\<Set\<Predicate\>, Type\>  
\<Type, Set\<Map\<Predicate, Value\>\>\>  
\<Map\<Set\<Map\<Predicate, Value\>\>, State\>

**Materialization of Resources: State / IO**

TODO: Refactor to IO / State Monad. Execution Resource Statements Schema.

“Primitive” Resources (Kinds) shall exist which allows for executable composition of streams models by their types and their internal instance state. Their signature may be a composite traversal of application invocations. For example, for the “createLink” Resource primitive could be invoked like:

createLinkResource::apply(subjectRes : Resource)::apply(predicateRes : Resource)::apply(objectRes : Resource) : Statement Resource

**Merge by means of Resource Application**

Merge phase of pipeline agents processing first applies its input source / production Statement to each corresponding already known Statement. It then recursively applies resulting / inferred application result Resource(s) to the corresponding already known Statement structure composition.

**Folding / Unfolding by means of Resource Application**

Kinds layers (aggregation Statement types) folding and unfolding may be also defined in terms of Resource(s) functional application. Then the streaming pipeline can be built in terms of those operations (merge, fold and unfold) with streaming flows corresponding to each Augmentation pipeline step.

In this way, folding and unfolding would become “contextualized” operations, where each application’s context is the previously applied Resource.

**Persistence and Endpoints Interactions by means of Resource Application**

TODO: A schema shall exist which encodes Persistence IO actions and Endpoints Context Interactions behaviors and executions into Execution Statements Materialization / State IO performances.

TODO:  
Resource hierarchy application semantics. Full layers types hierarchy (implement all layers models kinds). Template methods. Implementation Language? (Resources, Streams Processing), XSLT?

### Comparisons: Dimensional axis Order and Matching {#comparisons:-dimensional-axis-order-and-matching}

Folding and unfolding Merge operations can leverage comparisons of Resources for sorting and matching. This is sorting in a nested contexts approach where one sorted occurrence may be the ‘parent’ of child sorted occurrences (happened and sorted in the parent occurrence scope). Resource application can be used for sorted structures traversal and further comparisons.

TODO: For leveraging CPPE, Algebraic Embeddings and FCA the comparison results may be encoded in a 3 bit string mask (octal) representation, for example: 001 is less than, 100 is greater than, 111 is equal, etc.

One goal would be to be able to encode comparison results as Merge Materialized Merge Traversal Comparison Statements Results. Example: A to B in Context C is like D to E in Context F.

The means for being able to construct such Statements for comparisons is by means of PredicateKind. Reified Relationships aggregation:

(:subject, :employer / :position / :salary, :objects...)

\-\> (:subject, :employment, :anEmployment)

\-\> (:anEmployment, :attributes..., :values…)

:employment: WorkRelationship PredicateKind (materialize)  
:anEmployment: Employment Relationship Resource instance Kinds (ObjectKind, SubjectKind).

Attributes: Dimensional Axes. Values: PredicateKind ValueType Aggregation. Infer and materialize :anEmployment reified relationship object / subject for :employment predicate of WorkRelationship PredicateKind.

PredicateKind of SubjectKind Kind Attribute (Employee, Student) / ObjectKind Kind Value (Employer, School).

TODO: Infer  
Employee is to Employer (in WorkRelationship) as Student is to School (in StudentshipRelationship).

Materialize: (Resource, ComparisonEncoding(axis, binary mask), Resource).

Merge (materialize) Resources according to their axes binary mask comparison results.

Leverage CPPE, Algebraic Embeddings, FCA.

**Augmentation Layers Kinds Relationships Reification**

Augmentation Layers, particularly the Information or Alignment layer already performs such a PredicateKind relationship, aggregating those Kinds from Subject and Object Kinds. Knowledge Activation Layers performs the aggregation over the previously aggregated layer results. Such arrangements should allow for: Information Alignment axes ordering and matching and Knowledge Activation axes ordering and matching.

The examples shown so far may be appropriate for Information Alignment Layer instance data comparisons and inference. The Knowledge Activation layer should materialize ordering and matching of reified contexts and interactions of behavior instance data.

## Messaging Infrastructure {#messaging-infrastructure}

Messaging pipeline:

aggregationSourceTopic \<-\> Aggregation \<-\> aggregationProductionTopic

aggregationProductionTopic \<-\> Alignment \<-\> alignmentProductionTopic

alignmentProductionTopic \<-\> Activation \<-\> activationProductionTopic

### Messaging Format: TreeGraph {#messaging-format:-treegraph}

All Base Model entities Statements of each layer type must encode all of their corresponding composing entities in a single message. A Statement containing a specific Kind must encode all its Kind’s composing aggregation Statements, for example. 

Source, Production Messages includes all Statements hierarchy which compose / lead to produced Statements (TreeGraph). Serialization. References to Resources (Registry Helper Service) to reduce message payload size..

## Datasources {#datasources}

Raw RDF CSPO URIs Quad Statement Messages Endpoint. Configured to produce configured datasource data and to consume updated Statements synchronizing state. 

## Stream-Oriented Merge, Fold and Unfold of Layered Statements {#stream-oriented-merge,-fold-and-unfold-of-layered-statements}

As Resource functional composition (Homoiconic approach).

Layers inputs / outputs. Layers functional definitions. Rules from source 'terminals' to production 'non-terminals': produce all possible production source Statements given contexts / constraints. Inferences.

TODO

### Fold and Unfold as the Stream Context Resolution Operation {#fold-and-unfold-as-the-stream-context-resolution-operation}

TODO

### Merge as the Central Stream Contexts Operation {#merge-as-the-central-stream-contexts-operation}

Inferred new Statements by Augmentation pipeline phase.  
TODO

### Possible Merge Approaches {#possible-merge-approaches}

Identity Resolution driven. TODO: Find the way of unambiguously identifying concepts (Resources, Occurrences, Statements, SPOs, Kinds) equivalent (in a given role occurrence in a given context).

Merge: Reify as Resources Occurrences, Statements, SPOs, Kinds. Resolve ID of Resources, Contexts (ID, Type), Occurrences (IDs, Contexts, Roles).

Aggregated Processing / Production Statements acts as Templates / Upper ontology alignment schemas.

Layers context merged entities propagate upstream (unfolding) and downstream (folding).

Identity Encoding:

**CPPE Embeddings**  
Index API.

**FCA / Set Assertion Statements:**  
(Context, Concept, Role, Occurrence);  
Concept, Context, Role, Occurrence recursively instance of Set Statements.

Naming Scheme:  
Name assignment for inferred entities.  
Registry Mapping of Merge encodings.

#### RDF Merge {#rdf-merge}

This approach relies on graph theory. It essentially performs a graph union of multiple RDF datasets. A critical function of an RDF merge is the standardization and renaming of "blank nodes" (anonymous resources) across different graphs to avoid collisions, resulting in a single, unified knowledge graph of subject-predicate-object triples.

Merge Statements as RDF graph patterns, combining compatible subjects, predicates, and objects while preserving graph identity and provenance. This provides a straightforward representation for stream-level graph merging and interoperability with RDF-based tooling.

#### TMRM Merge {#tmrm-merge}

TMRM merging is driven strictly by subject identity. If two topics (entities) across different data streams share the same subject locator, subject identifier, or item identifier, they are deterministically merged into a single topic. The resulting merged topic accumulates all the names, occurrences, and associations of the original topics.

Perform merging at the TMRM metamodel level, using Resources, Occurrences, Statements, Subjects, Predicates, Objects, and Kinds as the semantic structures being matched and consolidated. This provides the underlying subject-centric merge and identity model for the pipeline.

#### FCA Merge {#fca-merge}

This approach merges data at the conceptual level by combining "formal contexts" (mappings of objects to their attributes). When two concept lattices are merged, the FCA algorithm recalculates the matrix to build a new, unified lattice. This is highly effective for discovering new structural hierarchies and implicit relationships that weren't visible in the isolated data streams.

Treat matching Statements as formal contexts and merge compatible contexts to derive shared Properties and higher-level relationships. This is particularly suited to the Aggregation phase, where input Statements are consolidated into Property Statements. 

#### CPPE Based FCA / Model Primitives Merge {#cppe-based-fca-/-model-primitives-merge}

Operating at the most atomic level of a data architecture, this approach aligns the fundamental structural primitives (e.g., core entities, base properties, and semantic rules) of the models. By merging the structural primitives *first*, the pipeline creates a standardized baseline context, which is then fed into an FCA merge to build highly accurate, normalized concept lattices.

Combine FCA context merging with CPPE/model primitives to support higher-level semantic matching and inference. This approach can be used in the Alignment phase to derive ontology matches, links, dimensions, ordering, and related Rule Statements. 

#### Sets Model Based Merge {#sets-model-based-merge}

Rooted in classic set theory, this methodology uses strict mathematical operations (unions, intersections, and relative differences) to combine data. It treats data streams as collections of elements, making it an incredibly fast, deterministic, and highly scalable approach for deduplication and exact-match aggregations.

Represent Statement components and their relationships as sets and apply set operations such as union, intersection, difference, and compatibility matching. This provides a simple compositional mechanism that can be used as a lower-level merge primitive within the other approaches.

#### Integration into Streams Processing {#integration-into-streams-processing}

TODO

## Streaming Agents Augmentation Pipeline {#streaming-agents-augmentation-pipeline}

Each pipeline Agent has three types of Statements: its Source Statements (consumes / produces), its internal Kind aggregation Statements (used in the merge phase of its processing) and its Production Statements (produces / consumes).

Any of the three layers can be considered as (sets of) Resources of their types of source and production Statements. Layer state. Streams application processing (layer endpoints, topics).

Aggregation (Data) Agent:  
Source Statement Type: Raw RDF CSPO URIs Quad Statements.  
Production Statement Type: (CK, SK, PK, OK) Property Quad Statements.

Alignment (Information) Agent:  
Source Statement Type: (CK, SK, PK, OK) Property Quad Statements.  
Production Statement Type: (CK, SK, PK, OK) Rule Quad Statements.

Activation (Knowledge) Agent:  
Source Statement Type: Actor Statements (Alignment Information Layer outputs)  
Production Statement Type: (CK, SK, PK, OK) Context Quad Statements.

TODO: Cleanup Agents Domain Model Examples.

### Aggregation Service Agent {#aggregation-service-agent}

Context / Role / Type inference in the Aggregation Layer.

#### Aggregation Agent Domain Model {#aggregation-agent-domain-model}

Data Layer. DOM (Dynamic Object Model)

**Data / Instance layer input Statements:**  
Source Statement Type. Raw CSPO RDF URIs Quad Statements.

(C, S, P, O)

**Type aggregation Statements:**  
Kinds aggregation Statement Types.

(ContextCK, S,  P, O)  
Context Kind, PlayerType: Context, AttributeType: Subject, ValueType: Object.   
Example: (EmploymentCK, :Peter, :worksFor, :anEnterprise)

(TypeSK, S,  P, O)  
SubjectKind, PlayerType: Subject, AttributeType: Predicate, ValueType: Object.  
Example: (EmployeeTypeSK, :Peter, :employer, :anEnterprise)

(PropertyPK, S,  P, O)  
Predicate Kind, PlayerType: Predicate, AttributeType: Subject, ValueType: Object.  
Example: (EmploymentRelationshipPropertyPK, :Peter, :worksFor, :anEnterprise)

(ValueOK, S,  P, O)  
Object Kind, PlayerType: Object, AttributeType: Predicate, ValueType: Subject.  
Example: (EmployerValueOK, :Peter, :employedBy, :anEnterprise)

**Property output Statements:**  
Production Statement Type.

(ContextCK, TypeSK, PropertyPK, ValueOK)

Example:  
(EmploymentContextKind, EmployeeSubjectKind, EmploymentRelationshipPredicateKind, EmployerObjectKind)

#### Aggregation Agent Merge / Fold / Unfold {#aggregation-agent-merge-/-fold-/-unfold}

See: Homoiconic (code as data) approach.  
TODO.

### Alignment Service Agent {#alignment-service-agent}

Ontology Matching / Links / Attributes / Dimensional / Order inference in the Alignment Layer.

#### Alignment Agent Domain Model {#alignment-agent-domain-model}

Information Layer. N-ary Dimensional Relationships Modelling.

**Axis layer input Statements:**  
Source Statement Type. Aggregation Production Statements.

(C, S, P, O)

(ContextCK, TypeSK, PropertyPK, ValueOK) from Aggregation Property Statements.  
Example:  
(EmploymentContextKind, EmployeeSubjectKind, EmploymentRelationshipPredicateKind, EmployerObjectKind)

**State aggregation Statements:**  
Kinds aggregation Statement Types.

(RelationshipCK, TypeSK, PropertyPK, ValueOK)  
Context Kind, PlayerType: ContextCK, AttributeType: TypeSK, ValueType: ValueOK.   
Example: (EmploymentRelationshipCK, EmployeeSubjectKind, EmploymentRelationshipPredicateKind, EmployerObjectKind)

(SourceEndSK, TypeSK, PropertyPK, ValueOK)  
Subject Kind, PlayerType: TypeSK, AttributeType: PropertyPK, ValueType: ValueOK.   
Example: (EmployeeRoleSK, EmployeeSubjectKind, EmploymentRoleRelationshipPredicateKind, EmployeeRoleObjectKind)

(MeasurementContextPK, TypeSK, PropertyPK, ValueOK)  
Predicate Kind, PlayerType: PropertySK, AttributeType: TypePK, ValueType: ValueOK.   
Example: (EmployeePositionAtDatePK, EmployeeSubjectKind, EmploymentPositionRelationshipPredicateKind, EmployeePositionObjectKind)

(DestinationEndOK, TypeSK,  PropertyPK, ValueOK)  
Object Kind, PlayerType: ValueOK, AttributeType: PropertyPK, ValueType: TypeSK.   
Example: (CurrentEmployeeRoleOK, EmployeeSubjectKind, EmploymentRoleRelationshipPredicateKind, EmployeeRoleObjectKind)

**Rule output Statements:**  
Production Statement Type.

(RelationshipCK, SourceEndSK, MeasurementContextPK, DestinationEndOK)

Example:  
(EmploymentRelationshipCK, EmployeeRoleSK, EmployeePositionAtDatePK, CurrentEmployeeRoleOK)

#### Alignment Agent Merge / Fold / Unfold {#alignment-agent-merge-/-fold-/-unfold}

See: Homoiconic (code as data) approach.  
TODO.

### Activation Service Agent {#activation-service-agent}

Contexts (Use Cases) and behaviors (Interactions) in the Activation Layer.

#### Activation Agent Domain Model {#activation-agent-domain-model}

Knowledge Layer. DCI Contexts, Roles, Actors, Interactions.

**Actor layer input Statements:**  
Source Statement Type. Alignment Rule Statements.

(C, S, P, O):  
(RelationshipCK, SourceEndSK, MeasurementContextPK, DestinationEndOK) from Alignment Rule Statements.

Example:  
(EmploymentRelationshipCK, EmployeeRoleSK, EmployeePositionAtDatePK, CurrentEmployeeRoleOK)

**Role Interaction aggregation Statements:**  
Kinds aggregation Statement Types.

(DCIContextCK, SourceEndSK, MeasurementContextPK, DestinationEndOK)  
Context Kind, PlayerType: DCIContexCK, AttributeType: MeasurementSK, ValueType: MeasurementOK.  
Example: (EmploymentDepartmentCK, EmploymentDepartmentMeasurementSK, EmploymentRoleDimensionPK, EmploymentRoleMeasurementOK)

(RoleSK, SourceEndSK, MeasurementContextPK, DestinationEndOK)  
Subject Kind, PlayerType: RoleSK, AttributeType: DimensionPK, ValueType: MeasurementOK.  
Example: (EmploymentDepartmentRoleSK, EmploymentDepartmentMeasurementSK, EmploymentRoleDimensionPK, EmploymentRoleMeasurementOK)

(ActorPK, SourceEndSK, MeasurementContextPK, DestinationEndOK)  
Predicate Kind, PlayerType: DimensionPK, AttributeType: MeasurementSK, ValueType: MeasurementOK.  
Example: (EmploymentDepartmentActorPK, EmploymentDepartmentMeasurementSK, EmploymentRoleDimensionPK, EmploymentRoleMeasurementOK)

(InteractionOK, SourceEndSK, MeasurementContextPK, DestinationEndOK)  
Object Kind, PlayerType: MeasurementOK, AttributeType: DimensionPK, ValueType: MeasurementSK.  
Example: (EmploymentDepartmentRoleOK, EmploymentRoleMeasurementSK, EmploymentRoleDimensionPK, EmploymentRoleMeasurementOK)

**Context output Statements:**  
Production Statement Type.

(DCIContextCK, RoleSK, ActorPK, InteractionOK)

Example:  
(DCIContextCK, EmploymentDepartmentRoleSK, EmploymentDepartmentRoleSK, EmploymentDepartamentRoleOK) 

#### Activation Agent Merge / Fold / Unfold {#activation-agent-merge-/-fold-/-unfold}

See: Homoiconic (code as data) approach.  
TODO.

### Helper Services {#helper-services}

Monadic wrapper bound Base Model Entities (Resource, Occurrence, Statement, Context, Subject, Predicate, Object, Kind, ContextKind, SubjectKind, PredicateKind, ObjectKind) Functional APIs Definitions for stream processing.

“Leverage X” Sections Functional APIs.

Kinds as Extensional Function Definitions Functional APIs.

Resource merge / “application” (transform / template) Functional APIs.

#### Registry Service {#registry-service}

Registry API Functional Definitions.

#### Naming Service {#naming-service}

Naming API Functional Definitions.

#### Index Service {#index-service}

Index API Functional Definitions.

## Dynamic API Endpoints {#dynamic-api-endpoints}

Activation pipeline layer production messages I/O API Facade for rendering Dynamic API Endpoints:

Render an interface / protocol of discoverable Contexts behavior (Use Cases) and Interactions instances (executions) API of the unified integrated datasources facade by means of Activation activated knowledge message statements.

Develop this interface as a protocol for clients browsing available Contexts, instantiating Contexts Interactions into new Use Cases instances or browsing previous Use Cases Interactions in a conversational (browsing state) manner. Allow for binding produced results or navigation state back into Augmentation pipeline for further Augmentation, Contexts and Interactions inference.

State / IO Monad functional approach for a DCI Contexts Interactions generic API interface consuming and producing Activation pipeline layer production messages. Messages fan in / fan out Augmentation pipeline for further execution and inference (merge, unfold, fold).

Highlight how Activation pipeline layer production messages are rendered as API schema, instances and inferences and how user interactions with this rendered interface modifies or produces new knowledge statements accordingly and how the Dynamic Endpoints communicate with Activation pipeline layer via a State / IO Monad approach for input / output / materialization of Activation production messages.

—

The "Dynamic API Endpoints" section of the document must outline how a generic API Facade could expose Activation layer Contexts, Roles, Interactions and Actors workflows (Use Cases, Use Case Instances) that can be browsed and executed by the API Resources rendered representations navigation means. 

API Facade endpoints produced and consumed API Resources rendered representations (REST) conveys all the navigational “state” of a “session” (State Monad). These representations are built from and rendered to the Activation layer Context production Statements: (DCIContextCK, RoleSK, ActorPK, InteractionOK). Leverage an State Monad pattern for navigational context and Augmentation pipeline state and an IO Monad for Activation layer Context production Statements transforms into API Endpoints rendered resources representations.

The API endpoints receive and produce API Representations rendered resources. They receive an API Representation rendered resource, transforms it into Activation layer Context production Statements, performs Activation (fans in / fans out all the Augmentation pipeline layers for inference) and renders back the updated Activation layer knowledge into API Representations rendered resources format.

This will be the “state” flowing across the rendered API endpoints resource representations and the backend Activation Layer message format in which API endpoints interactions resource representations are transformed back and forth (IO Monad). The initiating message (Resource) from a session could be the selection of a top level Context (Use Case). The client retrieves, inspects and posts back this representation and the response could be a list of the Use Case instances (Interactions) and a “New Interaction…” placeholder Resource. Then follow the same pattern for the other resource types: post a representation and obtain a list of available resources (parent, child, placeholder) for this resource type.

The "Generic Dynamic API Endpoints Browser / Designer" must outline

POST /contexts  
POST /contexts/{context}  
POST /contexts/{context}/interactions  
POST /contexts/{context}/interactions/{interaction}  
POST /resources/{resource} 

—

The Dynamic API Endpoint layer is the protocol boundary between the Activation layer and external clients. Activation produces Context/Role/Actor/Interaction Statements of the form `(DCIContextCK, RoleSK, ActorPK, InteractionOK)`. The Dynamic API consumes these activated Statements to render discoverable Context and Interaction representations and produces Interaction requests and navigation/binding events that are submitted back to Activation.

A State/IO Monad provides the functional execution model for this boundary. **State** represents the current API/interaction navigation state, including selected Contexts, Context instances, Actors, Roles, Interactions, execution results, bindings and navigation history. **IO** represents communication with the Activation message stream and its asynchronous production/consumption of Activation Statements.

Conceptually:

InteractionRequest  
      \+  
ActivationApiState  
      ↓  
State / IO computation  
      ↓  
Activation input message  
      ↓  
Activation processing  
      ↓  
Activation production message(s)  
      ↓  
updated ActivationApiState  
      \+  
InteractionResult

The Dynamic API renderer projects the resulting activated Statements and State into a discoverable HAL-like representation. API operations do not constitute a separate domain model; they are projections and interactions over Activation knowledge.

**Dynamic API Endpoints** define the **runtime protocol** by which activated Contexts, Roles, Actors, Resources and Interactions are discovered, instantiated, executed and observed.

The State/IO Monad applies to the Activation ↔ Dynamic API boundary; persistence and synchronization with underlying datasources remain concerns of the augmentation/data-source integration architecture and are not the responsibility of this API monad.

### Dynamic API Endpoints Integration {#dynamic-api-endpoints-integration}

The Dynamic API Endpoints section defines the runtime execution boundary between external consumers and the underlying semantic stream processing infrastructure. Implemented as an I/O API Facade, this layer projects activated knowledge statements into discoverable, executable interface representations while capturing client interactions and state transitions to feed back into the reactive augmentation stream.

#### Monadic Context & Interaction Pipeline {#monadic-context-&-interaction-pipeline}

The boundary between the Activation layer and the Dynamic API is governed by a combined **State / IO Monad** operational model:

* **State Monad**: Manages the runtime navigational state of a client session. It encapsulates active session variables, selected top-level Contexts (Use Cases), Interaction instances, Actor assignments, active Roles, execution parameters, and historical navigation paths across resource representations.  
* **IO Monad**: Handles the asynchronous, message-driven transformations between rendered REST/HAL resource representations and the backend Activation layer production Statements:

$ActivationStatement=(DCIContextCK,RoleSK,ActorPK,InteractionOK)$

                  \[ API Resource Representation \]  
                                │  
                                │ (IO Monad Input Transformation)  
                                ▼  
              \[ (DCIContextCK, RoleSK, ActorPK, InteractionOK) \]  
                                │  
                                │ (Augmentation Pipeline Fan-In)  
                                ▼  
                      \[ Activation Layer \]  
          (Inference / Merge / Fold / Unfold Execution)  
                                │  
                                │ (Augmentation Pipeline Fan-Out)  
                                ▼  
              \[ (DCIContextCK, RoleSK, ActorPK, InteractionOK) \]  
                                │  
                                │ (IO Monad Output Transformation)  
                                ▼  
                \[ Updated Navigation State Monad \]  
                                │  
                                ▼  
               \[ Rendered API Resource / Actions \]

#### Protocol Execution & Resource Traversal {#protocol-execution-&-resource-traversal}

The API Facade operates through a continuous RESTful resource navigation loop. Navigational state is conveyed entirely within the rendered resource representations, allowing clients to browse, inspect, and execute domain behaviors dynamically:

1. **Top-Level Discovery**: The client initiates a session by requesting the top-level Context root. The API responds with a representation listing available top-level Use Cases ($DCIContextCK$) and discovery hypermedia links.  
2. **Context Selection & Instance Enumeration**: Inspecting and posting a selected Use Case Context statement transforms the representation via the IO Monad into an Activation layer message. The Activation layer processes the message across the augmentation pipeline (fanning in/out through Aggregation, Alignment, and Activation) and returns updated knowledge statements.  
3. **Resource & Interaction Navigation**: The response renders a representation containing:  
   * A list of active Use Case instances ($Interactions$).  
   * Available participant Roles ($RoleSK$) and bound Actors ($ActorPK$).  
   * A "New Interaction..." placeholder Resource representing potential execution boundaries.  
4. **State Transition & Action Execution**: Submitting a payload to a placeholder or interaction resource triggers backend execution. The payload is converted into Activation production Statements, evaluated for state transitions (leveraging Previous, Current, Next networks and CPPE state transition products), and persisted across synchronized datasources. The updated state is rendered back to the client as new hypermedia controls and resource representations.

#### Generic Dynamic API Endpoints Browser / Designer {#generic-dynamic-api-endpoints-browser-/-designer}

The dynamic endpoints facade exposes two primary operational modes for generic client interaction:

* **Generic Semantic Browser**: A discoverable, hypermedia-driven UI layer that allows users to traverse available Use Cases, inspect active Context instances, view bound Roles/Actors, and trigger executable Interactions interactively.  
* **Context / Alignment Designer**: An interactive interface enabling administrators and domain designers to bind newly discovered graph resources, interaction results, and navigation states back into the reactive Augmentation Pipeline. These bindings generate new aligned rules, refine DCI Context definitions, and establish updated execution templates for continuous semantic augmentation.

### Dynamic API Endpoints API Architecture & Monadic Workflow {#dynamic-api-endpoints-api-architecture-&-monadic-workflow}

The generic **API Facade** exposes the Activation layer’s Contexts, Roles, Interactions, and Actors workflows (representing Use Cases and Use Case Instances) through discoverable REST resource representations. Client applications navigate, inspect, and execute these workflows directly via hypermedia navigation controls embedded within the rendered resource representations.

#### Monadic Execution Model: State and IO Monads {#monadic-execution-model:-state-and-io-monads}

The API Facade operates on a dual Monadic functional foundation:

* **State Monad**: Encapsulates all navigational state and session context across API resource interactions, tracking current Context selections, active Roles, bound Actors, execution histories, and Augmentation pipeline state.  
* **IO Monad**: Handles the asynchronous side-effects, message transformations, and I/O streams between the REST endpoints and the backend Activation Layer message pipeline.

API Resource Representation (REST)  
        │  (IO Monad: Unfold / Transform)  
        ▼  
Activation Production Statements: (DCIContextCK, RoleSK, ActorPK, InteractionOK)  
        │  (Fan-In / Fan-Out: Augmentation Pipeline Inference)  
        ▼  
Updated Knowledge & Inferred State  
        │  (IO Monad: Fold / Render)  
        ▼  
Updated API Resource Representation \+ Navigation Means (State Monad)

#### Activation Statements Transformation Flow {#activation-statements-transformation-flow}

The REST representations consumed and produced by API endpoints are anchored to the Activation layer production Quad Statements:

$ActivationStatement=(DCIContextCK,RoleSK,ActorPK,InteractionOK)$

The transformation and execution pipeline across the API endpoints proceeds as follows:

1. **Receive Resource Representation**: The endpoint receives an incoming API Representation resource conveying the client's current session state, submitted parameters, or selected navigational action.  
2. **Transform to Activation Statements (IO Monad)**: The IO Monad transforms the REST resource representation into Activation layer Context production Statements $(DCIContextCK,RoleSK,ActorPK,InteractionOK)$.  
3. **Activation & Augmentation Pipeline Processing**: The statement is submitted into the Activation layer, triggering a fan-in/fan-out across all Augmentation pipeline layers (Aggregation, Alignment, Activation) to perform inference, type resolution, link completion, and state transition calculations.  
4. **Render Updated Knowledge (IO Monad)**: The updated knowledge statements and inferred states produced by the pipeline are rendered back into API Resource rendered representations.  
5. **Navigational State Projection (State Monad)**: The State Monad threads updated hypermedia navigation controls, parent/child relationships, available actions, and placeholder resources back to the client representation.

#### Conversational Session & Resource Navigation Pattern {#conversational-session-&-resource-navigation-pattern}

The API Facade enforces a uniform, stateful REST browsing pattern across all resource types (Context, Role, Actor, Interaction):

1. **Top-Level Context Selection (Use Case Discovery)**:  
   * **Initiating Request**: A session begins when the client selects a top-level Context resource representing a Use Case (e.g., :CustomerOnboardingDCIContextCK).  
   * **Client Inspection**: The client retrieves and inspects this representation, which embeds available Roles, bound Actors, and state transition choices.  
2. **Context Instances & Interactions Listing**:  
   * **Post Representation**: The client posts back the Context representation to instantiate or navigate the selected Use Case.  
   * **Facaded Response**: The API responds with a list of active Use Case instances (Interactions) along with a canonical **"New Interaction..."** placeholder Resource.  
3. **Recursive Sub-Resource Traversal**:  
   * Following the same pattern for all other resource types (Role, Actor, Interaction), posting a resource representation yields a list of available related resources:  
     * **Parent Resources**: Enclosing Contexts and parent Roles.  
     * **Child Resources**: Active sub-interactions, bound Actors, and child state transitions.  
     * **Placeholder Resources**: Uninstantiated template representations (e.g., "New Role...", "New Actor...", "New Interaction...") enabling dynamic binding and creation.

By projecting Activation Statements into REST hypermedia, the API Facade maintains bidirectional synchronization between UI interactions and backend pipeline knowledge graphs.

### Dynamic API Endpoints Summary {#dynamic-api-endpoints-summary}

The Dynamic API Endpoint layer is the protocol boundary between the Activation layer and external clients. Activation production messages provide the executable knowledge from which the API Facade dynamically renders discoverable resources and interaction affordances. The fundamental Activation Context production Statement is:

(DCIContextCK, RoleSK, ActorPK, InteractionOK)

where the Context represents a Use Case, Roles represent the participating behavioral roles, Actors represent the participating execution resources, and Interactions represent executable Use Case behavior. The existing facade objective is therefore extended from merely exposing activated Statements to exposing their **rendered Resource representations as the navigational state of a REST session**.

A generic API Facade does not introduce another domain model. It renders Activation Resources, Contexts, Roles, Actors and Interactions as API Resources and exposes the relationships between those resources as navigational links and executable affordances. A client discovers a Use Case by following representations rather than by knowing a fixed endpoint vocabulary in advance. This preserves the HAL-like, discoverable character already established for the Unified Systems Facade.

#### Resource Representation and Navigational State {#resource-representation-and-navigational-state}

An API Resource representation is the externally visible projection of an Activation-layer Resource and its current navigational context. The representation contains both the resource data and the links or affordances through which the client may continue browsing or execute an Interaction.

Conceptually:

Activation Statements  
        ↓  
Resource / Occurrence / Statement materialization  
        ↓  
API Resource representation  
        ↓  
client inspects representation  
        ↓  
client follows a navigational affordance  
        ↓  
next API Resource representation

The representation therefore carries the **state of the session**. The URL alone is not the complete state of the interaction; the current representation, its selected Context, resource identity, available child resources, execution bindings, results and navigation affordances together constitute the navigational state.

A representation may consequently contain relations such as:

self  
parent  
context  
roles  
actors  
interactions  
instances  
new  
result  
next  
previous

The concrete URI layout is implementation-defined. The semantic identity of the resources and the transition between them is determined by the Activation Statements and by the current API State.

#### State Monad: API Navigation and Augmentation State {#state-monad:-api-navigation-and-augmentation-state}

The API Facade uses a **State Monad** to model the navigational state flowing across successive rendered API representations.

Conceptually:

State \=  
{  
    selected Context,  
    selected Role,  
    selected Actor,  
    selected Interaction,  
    Context instance,  
    Interaction instance,  
    bound Resources,  
    execution Result,  
    navigation history,  
    Augmentation bindings  
}

A navigation operation transforms one API State into another:

navigate(State, Representation)  
        → State'

The resulting State is then rendered into the next API Resource representation. Consequently, a representation returned by one endpoint can become the input representation to the next endpoint without requiring the client to reconstruct hidden session information.

This makes the API Resource representation itself the transferable **navigation state** of the session. The client retrieves a representation, inspects its available Resources and affordances, selects or modifies a representation, and posts that representation to request the corresponding next state.

The same State Monad also carries the state accumulated by the Augmentation pipeline interaction: selected Contexts, inferred Roles, bound Actors, discovered Interactions, produced results and any new statements that become available through execution.

#### IO Monad: API Representation ↔ Activation Statements {#io-monad:-api-representation-↔-activation-statements}

The **IO Monad** models the effectful boundary between the rendered REST resources and the Activation message stream.

The transformation is bidirectional:

API Representation  
        ↓  
Activation Context Production Statements  
        ↓  
Activation  
        ↓  
fan-in / fan-out Augmentation Pipeline  
        ↓  
new / updated Activation Statements  
        ↓  
API Representation

The API therefore does not directly execute business logic independently of the Augmentation Pipeline. An incoming API Resource representation is transformed into Activation-layer Context production Statements. Activation then merges, unfolds, folds and publishes the resulting knowledge through the same message-driven pipeline used by the other augmentation layers. The resulting Activation production messages are materialized back into API Resources and rendered as the response representation. The pipeline is explicitly defined as an asynchronous fan-in/fan-out stream in which production Statements may become inputs to subsequent processing and inference.

Conceptually:

InteractionRequest  
      \+  
ActivationApiState  
      ↓  
State / IO computation  
      ↓  
API Representation → Activation Statements  
      ↓  
Activation processing  
      ↓  
merge / unfold / fold  
      ↓  
Activation production Statement(s)  
      ↓  
Activation Statements → API Representation  
      ↓  
updated ActivationApiState  
      \+  
InteractionResult

Thus:

State \= navigational and augmentation session state

IO    \= effectful transformation and communication  
        between API Resources and Activation Statements

The State Monad determines **where the client is and what is currently known in the session**. The IO Monad determines **how that state is materialized into and out of the Activation message stream**.

#### Generic Contexts / Roles / Actors / Interactions Resources {#generic-contexts-/-roles-/-actors-/-interactions-resources}

The generic facade exposes the Activation hierarchy as navigable API Resources rather than as fixed application-specific controller methods.

A top-level Context Resource represents an inferred Use Case:

Context  
  ↓  
Roles  
  ↓  
Actors  
  ↓  
Interactions  
  ↓  
Interaction instances

A Context representation may therefore expose:

/context/{context-id}

{  
    "id": "...",  
    "kind": "DCIContextCK",  
    "name": "...",  
    "state": "...",  
    "\_links": {  
        "self": "...",  
        "parent": "...",  
        "roles": "...",  
        "actors": "...",  
        "interactions": "...",  
        "new": "..."  
    }  
}

The exact representation format is not normative; the important property is that the rendered Resource contains sufficient state and navigation information to continue the interaction.

A Role Resource identifies the Role participating in the selected Context:

/context/{context-id}/roles/{role-id}

An Actor Resource identifies the Actor associated with that Role and Context:

/context/{context-id}/actors/{actor-id}

An Interaction Resource identifies an executable behavior:

/context/{context-id}/interactions/{interaction-id}

An Interaction instance represents a concrete execution of a Use Case:

/context/{context-id}/interactions/{interaction-id}/instances/{instance-id}

The `new` affordance is itself a Resource representation rather than a special out-of-band command. Following or posting to this Resource requests materialization of a new Context, Role, Actor or Interaction instance.

#### Browsing a Use Case as REST Resource Navigation {#browsing-a-use-case-as-rest-resource-navigation}

The initiating Resource for a session may be the selection of a top-level Context, which corresponds to a Use Case.

For example:

GET /contexts  
        ↓  
list of Context Resources  
        \+  
"New Context..." Resource

The client retrieves a Context representation:

GET /contexts/{context}

and receives a representation containing the Context state and the available navigation affordances:

Context Resource  
    parent  
    child Roles  
    child Actors  
    child Interactions  
    previous instances  
    "New Interaction..." placeholder

The client then posts the inspected representation, or the representation of the selected Context state:

POST /contexts/{context}  
        ↓  
Activation Context production Statements  
        ↓  
Activation  
        ↓  
Interaction Resources

The resulting representation may contain:

{  
    "context": "...",  
    "instances": \[  
        "...InteractionInstance1...",  
        "...InteractionInstance2..."  
    \],  
    "\_links": {  
        "parent": "...",  
        "context": "...",  
        "new": ".../interactions/new"  
    }  
}

The important property is that the response is **not merely a collection returned by a query**. It is the next navigational state of the session. It contains the available parent, child, previous-instance and placeholder Resources from which the client can continue.

The same protocol applies recursively to all resource types:

POST representation  
        ↓  
Activation transformation / execution  
        ↓  
list of available Resources  
        ↓  
(parent)  
(child)  
(previous instance)  
(new placeholder)  
(next affordance)

Consequently, a generic client need not contain prior knowledge of the individual application's Context, Role, Actor or Interaction endpoint structure. It follows the Resources rendered by the current representation.

#### Resource Rendering from Activation Production Statements {#resource-rendering-from-activation-production-statements}

The Activation production Statement:

(DCIContextCK, RoleSK, ActorPK, InteractionOK)

is the source structure from which the facade renders Context and Interaction Resources.

The rendering process may be understood as:

(DCIContextCK, RoleSK, ActorPK, InteractionOK)  
                         ↓  
                 Resource materialization  
                         ↓  
              Context Resource representation  
                         ↓  
       Roles / Actors / Interactions links  
                         ↓  
        executable Interaction affordances

Conversely, when a client posts an Interaction representation:

API Interaction Resource  
        ↓  
Resource → Occurrence → Statement transformation  
        ↓  
(DCIContextCK, RoleSK, ActorPK, InteractionOK)  
        ↓  
Activation

the posted representation becomes an Activation message rather than being treated as an unrelated REST command.

This preserves the document's homoiconic principle: Resources, Statements and Kinds can participate in functional application and composition, while fold/unfold and merge operations provide the means for carrying those transformations through the streaming pipeline.

#### Executing an Interaction {#executing-an-interaction}

An Interaction Resource is both descriptive and executable. Its representation identifies the currently applicable Context, Role and Actor state and exposes an execution affordance.

Conceptually:

GET /contexts/{context}/interactions/{interaction}  
        ↓  
Interaction Resource representation  
        ↓  
POST representation  
        ↓  
Interaction execution request  
        ↓  
Activation input message  
        ↓  
Activation  
        ↓  
updated Context / Interaction state  
        ↓  
result representation

Execution may cause the Activation layer to unfold the selected production Statement into the underlying Rule and Property Statements, infer or complete additional state, and fan the resulting messages back through the pipeline. This is consistent with the existing execution model in which Activation production Statements can be consumed again as inputs and unfolded into their originating structures.

The response therefore renders the **updated Activation knowledge**, not merely an acknowledgment that the HTTP request was accepted.

For example:

POST /contexts/customer-onboarding/interactions/initiate

request:  
    Interaction Resource representation

response:  
    Interaction Instance Resource representation

    {  
        "state": "...",  
        "result": "...",  
        "\_links": {  
            "self": "...",  
            "context": "...",  
            "parent": "...",  
            "next": "...",  
            "previous": "..."  
        }  
    }

An executed Interaction becomes a navigable Resource that can be inspected, revisited and used as the starting representation for the next interaction.

#### Parent, Child and Placeholder Resources {#parent,-child-and-placeholder-resources}

The generic facade treats browsing as a uniform operation over Resource representations.

For each current Resource representation, the facade may render:

Current Resource  
      ├── parent Resource  
      ├── current Resource  
      ├── child Resources  
      ├── previous instance Resources  
      └── "New ..." placeholder Resource

The placeholder is significant because it represents an **available state transition** rather than a missing Resource. A `New Interaction...` Resource means that the current Context supports materialization of another Interaction instance.

The same pattern applies to:

Contexts  
Roles  
Actors  
Interactions  
Interaction Instances  
Resources bound to an Interaction  
Execution Results

The generic API browser can therefore be implemented without specialized screens for each discovered Use Case. It renders the Resources and affordances contained in the current representation and follows the state transitions they describe.

#### API Facade and Augmentation Pipeline Feedback {#api-facade-and-augmentation-pipeline-feedback}

API execution is also an input to the inference architecture. A representation posted by the client can contain selected Resources, bindings and execution results that become new Activation inputs. These messages can fan back into the Augmentation Pipeline so that execution state contributes to subsequent merge, fold and unfold operations and can lead to further inferred Contexts, Roles and Interactions.

API session  
    ↓  
rendered Resource representation  
    ↓  
Activation production Statement  
    ↓  
Activation  
    ↓  
Augmentation fan-out  
    ↓  
new inferred knowledge  
    ↓  
Activation production Statement  
    ↓  
API Resource representation

The facade consequently forms a bidirectional boundary rather than a terminal presentation layer:

Datasource statements  
        ↓  
Aggregation  
        ↓  
Alignment  
        ↓  
Activation  
        ↓  
Dynamic API  
        ↓  
client navigation / execution  
        ↓  
Activation  
        ↓  
Alignment / Aggregation / Activation  
        ↓  
updated knowledge  
        ↓  
Dynamic API

This retains the framework's principle that the unified facade is generated from inferred semantic Resources, Kinds, Relationships, Contexts, Roles, Actors and Interactions, while Resource views expose integrated state and Interaction endpoints expose executable Contexts and state transitions.

#### Generic Dynamic API Protocol {#generic-dynamic-api-protocol}

The resulting protocol can therefore be summarized as:

1\. GET a representation  
2\. Inspect its state and navigation affordances  
3\. Follow a parent, child, instance or "new" Resource  
4\. POST the selected Resource representation  
5\. Transform representation → Activation Statements  
6\. Activate and fan-in / fan-out the Augmentation Pipeline  
7\. Materialize resulting Activation Statements  
8\. Render the updated Resource representation  
9\. Continue navigation from the returned representation

The API endpoint set is therefore **generic and dynamically generated**. Endpoint behavior derives from the Resources and Activation Context Statements currently known by the system rather than from a statically authored controller hierarchy.

## Generic Dynamic API Endpoints Browser / Designer {#generic-dynamic-api-endpoints-browser-/-designer-1}

Render a default Dynamic API Endpoints User Interface allowing for Use Case Contexts, Behavior Interactions and Augmentation pipeline alignments and bindings browsing of available knowledge.

Allow for binding produced results or navigation state back into Augmentation pipeline for further Augmentation, Contexts and Interactions inference.

**Generic Dynamic API Endpoints Browser / Designer** defines the **reference client** for that protocol: a generic semantic browser for discovering and executing activated capabilities, plus a designer for binding resources, interaction results, navigation state and augmentation outputs into new executable Contexts and Interactions.

The **Generic Dynamic API Endpoints Browser / Designer** is the reference client for this protocol. It renders the current API Resource representation, exposes its navigation affordances, permits Context / Role / Actor / Interaction browsing and execution, and allows produced results, resource bindings and navigation state to be submitted back into the Augmentation Pipeline.

It may consequently act simultaneously as:

Semantic Resource Browser  
        \+  
Use Case / Context Browser  
        \+  
Interaction Executor  
        \+  
Interaction Instance History  
        \+  
Augmentation Binding Designer

The browser/designer is not a separate semantic authority. It is a generic client over the Dynamic API protocol; the authoritative semantic state remains the Activation-layer Resources and Statements from which the representations are rendered.

# Implementation Techniques {#implementation-techniques}

The framework's primary objective is to build a semantic, RDF-based data integration and intelligence system. It processes raw CSPO (Context, Subject, Predicate, Object) RDF graph streams through a reactive three-stage Augmentation Pipeline—**Aggregation** (data/type/role inference), **Alignment** (information/ontology matching, links, ordering), and **Activation** (knowledge/contexts, DCI behaviors, interactions)—to yield executable domain models, exposing a unified Contexts and Interactions API while maintaining real-time synchronization with underlying source datasources.

The techniques below are complementary implementation mechanisms for the same Base Model and Augmentation Pipeline. Each technique provides a computational lens for one or more operations—representation, traversal, classification, matching, inference, execution, identity, or interaction—while results are ultimately expressed as Resources, Occurrences, Statements and Kinds and propagated through Aggregation, Alignment and Activation.

## Leverage TMRM (ISO Topic Maps Reference Model) {#leverage-tmrm-(iso-topic-maps-reference-model)}

Underlying graph metamodel.

### 

* **Metamodel Foundation**: Serves as the underlying, subject-centric graph metamodel for representing Resource, Occurrence, Statement, and Kind base structures.  
* **Contribution to Framework Objective**: Provides an implementation-independent semantic substrate that handles resource identity, graph traversal, reified statement management, and context-preserving access. This allows the Aggregation, Alignment, and Activation pipeline layers to share a unified graph representation without losing provenance or context.

Use the ISO Topic Maps Reference Model (TMRM) as the underlying graph metamodel for the Base Model, providing a subject-centric and implementation-independent foundation for representing `Resource`, `Occurrence`, `Statement`, `Subject`, `Predicate`, `Object`, and their associated `Kind` structures. The Base Model can be mapped onto TMRM subject proxies and properties, with Statements providing the reified graph relationships and Occurrences providing the contextual roles in which Resources participate.

TMRM can therefore provide the semantic graph substrate and generic graph operations required by the service, while the Base Model and Augmentation Pipeline define the application-specific semantics and processing layers. In particular, the metamodel should support APIs for:

* **Resource / subject management:** create, identify, retrieve, update and merge graph resources/subject proxies, including stable URI-based identity.  
* **Statement management:** create, retrieve, remove and traverse reified `S-P-O` Statements and their contextual Occurrences and roles.  
* **Graph traversal:** navigate subjects, predicates, objects, occurrences, contexts and their relationships, including recursive traversal of Kinds and Statements.  
* **Context-preserving access:** retrieve the statements and properties associated with a subject while preserving the context in which each relationship or occurrence was asserted.  
* **Property and kind access:** expose the properties of a resource and the Statements defining `SubjectKind`, `PredicateKind` and `ObjectKind`, supporting the classification structures used by the Aggregation phase.  
* **Pattern/query access:** match graph structures and Statement patterns so that Augmentation Pipeline agents can discover applicable processing Statements and apply them to input Statement streams.  
* **Identity and merging:** provide subject identity/merging facilities that allow information about the same underlying subject from different sources or streams to be consolidated without losing its provenance/context.  
* **Schema/constraint support:** expose the metamodel structures needed by higher-level services to validate or constrain the graph, while leaving the specific application constraints to the service model.

The TMRM layer is thus primarily responsible for **representing and accessing the semantic graph**, rather than implementing the Aggregation, Alignment or Activation semantics themselves. Those services consume and produce the graph structures through the metamodel APIs, allowing the same underlying graph representation to support the DOM, Dimensional and DCI layers described by the Augmentation Pipeline.

This also provides a natural foundation for the existing FCA and CPPE components: FCA can operate over the subject/property structures exposed by the graph, while CPPE can use Resource/Statement identities and identifiers as inputs to its numerical inference mechanisms.

TMRM supplies the semantic substrate; the augmentation layers supply the application-specific inference semantics.

## Leverage Dimensional Features {#leverage-dimensional-features}

See: “Sets layout for Dimensional Analysis”  
See: “Context’s ContextKind(s) Dimensional Roles”

* **Dimensional & State Modeling**: Utilizes power set attribute inclusions to define ordering and hierarchies, alongside PCN (Previous, Current, Next) state transition networks for graph node flows.  
* **Contribution to Framework Objective**: Directly powers the **Alignment** (axis ordering and dimensional relationships) and **Activation** (state transition networks and behavioral flows) pipeline stages, enabling raw data mutations to be interpreted as structured, executable business interactions.

**Purpose**

Represent semantic differences as axes, dimensions, states and transitions.

**Core mechanisms**

* Attribute power sets.  
* Subset/superset ordering.  
* Kind hierarchies.  
* Dimensional axes.  
* Previous/Current/Next (PCN) transitions.  
* Reified relationships.

**End-to-end contribution**

**Aggregation:** infer Kinds and type/state hierarchies from recurring attributes.  
**Alignment:** compare entities across dimensions and establish ordering/analogy.  
**Activation:** represent state transitions and contextual behaviors.

Dimensional features turn static graph structure into an ordered semantic space in which equivalence, extension, transition and analogy can be represented explicitly.

Statement Predicates are the Type or Instance of an Action / Verb

:name instanceOf :naming

The Power Set of every attribute contains the sets of attributes of every possible class / concept. Includes relation defines an ordering over the power set. Power Sets (CSPO / Reified Types Sets). All possible Subjects, Predicate, Objects, Kinds Grouped Types. Order Relationship (Includes). CSPO Sets Intersection: All possible Statements. Grammar (production from possible rules).

Order and hierarchies are defined by subset / superset relationships. An object having attributes who are a superset of another object attributes is “extending” or “after” this object.  
Dimensional (Contexts) Features

Kinds, type / state hierarchy / order inference and materialization into Statements. 

Alignment. Order (axis arrangements). State transitions flow. Infer and encode types / instances state transition networks on a given context on a given event: 

* PCN (Previous, Current, Next) in axis / scope Graph Traversal Node Types: Individuals, States (occurrences role types), Associations (events). Order Hierarchies. Contexts:  
  * (Single, Marriage, Married);  
  * (Married, Divorce, Divorced);  
  * (Single, Married, Divorced);  
  * (Junior, Promotion, Semisenior);  
  * (Junior, Semisenior, Senior);  
  * (Unemployed, Employment, Employee);  
  * (Unemployed, Employed, Unemployed);  
  * (John, successor, Peter);

Leveraging Grammars as an LLM Interaction tool

Possible contexts / functional transitions (behavior) as formal grammars rules / productions.  
Possible Prompts in context. Contexts Roles behaviors Flows. Inference context productions from grammars. Statements as grammar rules / productions.

## Leverage Formal Grammars {#leverage-formal-grammars}

**Grammatical Production Rules**: Maps Non-Terminals to Kinds, Terminals to Resources, and Production Rules to pipeline Statements using monadic parsers.

**Contribution to Framework Objective**: Formalizes stream processing as a dynamic grammar expansion process. Raw statements are parsed into functional non-terminal concepts (**Aggregation**), matched and ordered through production rules (**Alignment**), and evaluated to generate prompts, rules, and interaction executions (**Activation**).

**End-to-end contribution**

**Aggregation:** infer grammar rules from observed Statements.  
**Alignment:** determine valid/analogous productions and their dimensional ordering.  
**Activation:** start from a contextual Statement and execute applicable productions.

Layered Production Rules Composition:

Formal Grammars Rules Productions for Classification, Matching, Completion, Order / Comparisons and potential Contexts / Interactions Rules Productions.

**Non Terminals:** Kinds  
**Terminals:** Resources  
**Production Rules:** Aggregation, Alignment, Activation layers input / source, output / production Statements.  
**Start Symbol:** (Occurrence, Occurrence, Occurrence, Occurrence):  
TODO: Refactor class model. Context, Subject, Predicate, Object are the roles in the Statement determined by the Kind of the Occurrence.

**Rules Productions:** Layered Rules Production Statements materialization. Contextualized, until no non-terminals: Non Terminals: Functional Relationships (functional merge).

**Monadic parser.** Dynamic grammars / DSLs (upper Grammars / Contexts / Kinds aligned). Rules / Productions : Schema / Occurrences.

**Aggregation:**  
Infer Rules (Grammar) from Productions (Statements).

**Alignment:**  
All possible Grammar Production Rules Statements, all actual / valid grammar rules production Statements (matches Functional Relationships / Kinds merge).  
Order / Dimensions: Rules Productions as part / step of another Production Rule.

**Activation:**  
Prompt: Statement (from contextual possible start statements interactions list), Merge: Abstract Statement Production Rules (Aggregation), Unfold: scan all possible Statements from abstracted Statement Production Rules (Alignment). Perform Productions from Rules starting at scanned possible Statements.

## Leverage RDF, RDFS, OWL and SPARQL {#leverage-rdf,-rdfs,-owl-and-sparql}

**Standardized Graph Infrastructure**: Employs raw RDF Quad/Triple stores, SPARQL endpoints, and standard W3C semantic web ontologies.

**Contribution to Framework Objective**: Guarantees universal interoperability and ingestion capabilities from any legacy database or backend capable of exporting RDF graph representations, enabling seamless graph pattern matching across heterogeneous data streams.

**Purpose**

Exploit existing semantic-web infrastructure for:

* graph querying,  
* schema/type representation,  
* inference,  
* constraints,  
* external interoperability.

**End-to-end contribution**

**Aggregation:** query source statements and structural patterns; derive or validate types.  
**Alignment:** use graph patterns and ontology constructs to find correspondences and relationships.  
**Activation:** query discovered contexts, roles and interactions and persist resulting statements.

RDF is the representation; RDF / RDFS / OWL / SPARQL are implementation capabilities operating on that representation.

## Leverage Sets Model {#leverage-sets-model}

See: Sets layout for Dimensional Analysis

**Mathematical Set Primitives**: Defines Contexts, Subjects, Predicates, Objects, and Kinds as mathematical sets, applying union, intersection, and relative difference operations.

**Contribution to Framework Objective**: Delivers an ultra-fast, deterministic, low-level merge primitive for stream processing, facilitating immediate deduplication and exact-match aggregation before higher-level lattices or embeddings are computed.

**Purpose**

Provide deterministic algebra over:

* Subjects,  
* Predicates,  
* Objects,  
* Contexts,  
* Kinds,  
* Statement components.

**Core operations**

* Union  
* Intersection  
* Difference  
* Inclusion / subset  
* Compatibility

**End-to-end contribution**

**Aggregation:** intersection/commonality → type inference.  
**Alignment:** set inclusion and difference → structural correspondence.  
**Activation:** sets of possible states/transitions → candidate execution structures.  
**Merge:** exact / deterministic identity and deduplication.

## Leverage ML and LLMs {#leverage-ml-and-llms}

**Probabilistic & Semantic Inference**: Maps Machine Learning tasks directly to pipeline stages: Classification for **Aggregation**, Clustering for **Alignment**, and Regression/Generation for **Activation**.

**Contribution to Framework Objective**: Augments deterministic rules with data-driven predictions, enabling the automated inference of functional Kinds comprehensions, state transitions, and context prompts within the dynamic user API.

**Aggregation — classification**  
Predict Resource/Occurrence Kind membership from observed attributes and relationships.

**Alignment — clustering / similarity**  
Identify potentially equivalent or analogous entities, schemas, dimensions and relationships.

**Activation — prediction/regression**  
Estimate or infer state transitions or interaction outcomes from contextual information.

## Leverage MCP (Model Context Protocol) {#leverage-mcp-(model-context-protocol)}

**Dynamic Protocol Binding**: Integrates MCP to expose context-aware tool endpoints and AI agent interfaces.

**Contribution to Framework Objective**: Allows external AI agents and LLMs to dynamically inspect, discover, and trigger activated domain contexts, roles, and executable behaviors exposed by the framework's API.

**Purpose**

Expose semantic resources, contexts, interactions and augmentation capabilities as discoverable tool/context interfaces.

**End-to-end contribution**

**Aggregation:** expose discovered resources and their semantic descriptions.  
**Alignment:** expose matching/query/inference capabilities as tools.  
**Activation:** expose executable Contexts and Interactions as tool invocations.

## Leverage FCA {#leverage-fca}

Formal Concept Analysis for classification, types and attributes inference.

**Lattice-Based Schema Inference**: Constructs formal contexts across three perspectives (*Predicate-as-Context*, *Subject-as-Context*, and *Object-as-Context*) to build concept lattices.

**Contribution to Framework Objective**: Automates structural classification and type inference in **Aggregation**, while materializing relational schemas and upper-level ontology structures in **Alignment** directly from observed statement patterns.

**Purpose**

Derive concepts, types, attributes, shared properties and relational schemas from the Base Model.

**End-to-end contribution**

**Aggregation**

* infer SubjectKinds, PredicateKinds, ObjectKinds,  
* identify common attribute/value structures.

**Alignment**

* merge formal contexts,  
* discover shared conceptual structures,  
* derive relational schemas,  
* establish higher-level mappings.

**Activation**

* use inferred concepts and relations as the semantic vocabulary for contexts, roles and interactions.

**Materialization**

The important architectural step is:

**FCA observation → formal concept → inferred Kind/schema → Statement materialization → downstream pipeline**

**Subjects as Contexts:**  
Objects: Statement Predicates  
Attributes: Statement Objects

**Predicates as Contexts:**  
Objects: Statement Subjects  
Attributes: Statement Objects

**Objects as Contexts:**  
Objects: Statement Subjects  
Attributes: Statement Predicates

Formal Concept Analysis (FCA) can be used as an inference model over the Base Model to derive classifications, types, attributes and shared properties from the Resource/Occurrence/Statement structures. FCA should operate on the graph structures exposed by the TMRM layer, treating the reified Statements as the source of object–attribute incidence relations rather than introducing a separate representation.

The three FCA contexts defined above provide complementary inference views:

* **Subject context:** Subjects are FCA contexts, Statement Predicates are objects, and Statement Objects are attributes. This allows the system to infer concepts representing groups of Subjects sharing predicate/object characteristics.  
* **Predicate context:** Predicates are contexts, Statement Subjects are objects, and Statement Objects are attributes. This can infer common domains, ranges and behavioral/property patterns for predicates.  
* **Object context:** Objects are contexts, Statement Subjects are objects, and Statement Predicates are attributes. This can infer classifications of objects based on the predicates through which they occur.

### FCA-based Relational Schema Inference {#fca-based-relational-schema-inference}

The system can infer relational schemas (rules or "upper concepts") from the structure of the data itself using FCA.

* **FCA Contexts for Relational Analysis:** We use three types of FCA contexts to analyze relationships from different perspectives:  
  1. **Predicate-as-Context:** (FCA Objects: Statement Subjects, FCA Attributes: Statement Objects, FCA Context: Statement Predicate). This context reveals which types of subjects relate to which types of objects for a given predicate.  
  2. **Subject-as-Context:** (FCA Objects: Statement Predicates, FCA Attributes: Statement Objects, FCA Context: Statement Subjects). This reveals all the relationships and objects associated with a given subject, defining its role.  
  3. **Object-as-Context:** (FCA Objects: Statement Subjects, FCA Attributes: Statements Predicates, FCA Context: Statement Objects). This reveals all the subjects and actions that affect a given object.  
* **Algorithm: Inferring Relational Schema:**  
  1. **Select Context:** For a given predicate P (e.g., :worksOn), the Alignment Service constructs the Predicate-as-Context.  
  2. **Build Lattice:** It uses an FCA library (e.g., fcalib) to compute the concept lattice from this context.  
  3. **Identify Formal Concepts:** Each node in the lattice is a formal concept (A, B), where A is a set of subjects (the "extent") and B is the set of objects they all share (the "intent").  
  4. Materialize Schema: Each formal concept represents an inferred relational schema or "upper concept". The system creates a new RDF class for this concept. For a concept where the extent is {dev1, dev2} (both :Developers) and the intent is {projA, projB} (both :Projects), the system can materialize a schema:  
     :DeveloperWorksOnProject a rdfs:Class, :RelationalSchema ;  
     :hasDomain :Developer ;  
     :hasRange :Project .

## Leverage CPPE {#leverage-cppe}

Algebraic inference by means of numerical prime numbers IDs embeddings.

**Purpose**

Encode contextual graph structure numerically using Prime IDs and products.

**End-to-end contribution**

**Aggregation:** algebraic type inference.  
**Alignment:** similarity, ratios, GCD / LCM-based structural comparison.  
**Activation:** state-transition/product matching.

CPPE pipeline operators are:

* **Contains** → contextual/subgraph filtering.  
* **Intersection** → Aggregation/commonality.  
* **Axis Shift** → Alignment/reprojection.

**Algebraic Semantic Embeddings**: Assigns unique prime number IDs to Resources and calculates triadic products ($S,P,O$ Relational Context Vectors). Uses algebraic operators (GCD for intersection, Prime Ratios for axis shifts, Prime Products for state transitions).

**Contribution to Framework Objective**: Replaces expensive vector search and graph joins with $O(1)$ CPU-native arithmetic (modulo, GCD, LCM). Enables instant type checking, deterministic similarity matching, and reactive stream filtering across all pipeline stages.

### Algebraic Semantic Embeddings (CPPE): {#algebraic-semantic-embeddings-(cppe):}

#### Prime Numbers Identifiers: {#prime-numbers-identifiers:}

Every Resource is assigned a unique Prime Number ID (sequence) associated with its URI (via Registry Helper Service API).

#### Prime ID Embeddings: {#prime-id-embeddings:}

Each Resource is assigned an unique incremental Prime Number Identifier.

For a given Resource occurrence in a given Statement context its Prime ID Embedding is calculated as the product of this occurrence Resource Prime ID Embedding with the Prime ID Embeddings of the other two parts of the Statement occurrences.

For example: given an object occurrences its Prime ID Embedding is the product of its Prime ID (Embedding) by the Prime ID (Embedding) of the other occurrences components.

Augmentation Layers. Stream Pipelines:  
Aggregation, Alignment, Activation steps. Leverage Prime ID Embeddings for reactive functional composition.

#### CPPE. FCA-based Embeddings: A Deterministic Approach: {#cppe.-fca-based-embeddings:-a-deterministic-approach:}

Resource Embeddings are calculated by the product of the Resource's Prime ID by the product of the Resource's Occurrences Attributes and Values Prime IDs.

We will replace LLM-based embeddings with deterministic, structural embeddings derived from FCA contexts and prime number products. This provides explainable similarity based on shared roles and relationships.

* **Contextual Prime Product Embedding (CPPE):** For any Occurrence (i.e., a resource in a specific statement), we can calculate an embedding based on its relational context.  
  1. **Define FCA Contexts:** For a given relation (predicate), we can form an FCA context. Example: For the predicate :worksFor:  
     * **Objects (G):** The set of all subjects of :worksFor statements (e.g., {id:Alice, id:Bob}).  
     * **Attributes (M):** The set of all objects of :worksFor statements (e.g., {id:Google, id:StartupX}).  
  2. **Calculate Prime Product:** The CPPE for id:Google within the :worksFor context is the product of the primeIDs of all employees who work there. CPPE(Google, worksFor) \= primeID(Alice) \* primeID(Bob) \* ...  
* **Similarity Calculation & Inference:**  
  * **Similarity:** The similarity between two entities in the same context is the Greatest Common Divisor (GCD) of their CPPEs. GCD(CPPE(Google), CPPE(StartupX)) reveals the primeID product of their shared employees, giving a measure of personnel overlap.  
  * **Relational Inference:** We can infer complex relationships. Consider the goal of finding an "uncle".  
    1. Calculate the CPPE for "Person A" in the :brotherOf context (the product of their siblings' primes).  
    2. Calculate the CPPE for "Person B" in the :fatherOf context (the product of their children's primes).  
    3. If GCD(CPPE\_brotherOf(A), CPPE\_fatherOf(B)) \> 1, it means A is the brother of B's father. The system can then materialize a new triple: (A, :uncleOf, ChildOfB). This inference is stored and queryable.

##### Relational Context Vectors {#relational-context-vectors}

The core of this approach is the Relational Context Vector (RCV). For any given statement (a reified triple), we compute a vector of three BigInteger values, (S, P, O). Each component is a CPPE calculated from one of the three FCA context perspectives, providing a holistic numerical signature of the statement's role in the graph.

* **RCV Definition:** RCV(statement) \= (S, P, O)  
  * **S (Subject Context Embedding):** The CPPE of the statement's subject from the Subject-as-Context perspective. This number encodes everything the subject does. S \= calculateCPPE(statement.subject, SubjectAsContext)  
  * **P (Predicate Context Embedding):** The CPPE of the statement's predicate from the Predicate-as-Context perspective. This number encodes every subject-object pair the predicate connects. P \= calculateCPPE(statement.predicate, PredicateAsContext)  
  * **O (Object Context Embedding):** The CPPE of the statement's object from the Object-as-Context perspective. This number encodes everything that happens to the object. O \= calculateCPPE(statement.object, ObjectAsContext)  
* **Implementation:** A Java record RCV(BigInteger s, BigInteger p, BigInteger o). The Index Service is responsible for calculating and caching the RCV for every reified statement in the graph.

### 

##### Schema Archetypes: {#schema-archetypes:}

This dual representation is key to performing inference.

* **Instance RCV:** The RCV calculated for a specific, concrete statement (e.g., stmt\_123: (dev:Alice, :worksOn, proj:Orion)) is its unique numerical signature. It represents a single data point.  
* **Schema RCV (Archetype):** The RCV for a relational schema (e.g., the :DeveloperWorksOnProject schema) is an "archetype" vector. It is calculated by finding the Least Common Multiple (LCM) of the corresponding components of all instance RCVs that belong to that schema.  
  * **Algorithm: calculateSchemaRCV(schemaURI)**  
    1. Find all instance statements s\_i where s\_i rdf:type schemaURI.  
    2. For each instance s\_i, retrieve its cached RCV\_i \= (S\_i, P\_i, O\_i).  
    3. Calculate the schema RCV components:  
       * S\_schema \= LCM(S\_1, S\_2, ..., S\_n)  
       * P\_schema \= LCM(P\_1, P\_2, ..., P\_n)  
       * O\_schema \= LCM(O\_1, O\_2, ..., O\_n)  
    4. The result (S\_schema, P\_schema, O\_schema) is the numerical archetype for the schema. The LCM ensures that the schema's numerical signature is "divisible" by all of its instances.

##### Subsumption: {#subsumption:}

**Subsumption / Instance Checking (rdf:type):**

* **Concept:** An instance belongs to a schema if the instance's RCV "divides into" the schema's RCV.  
* **Algorithm: isInstanceOf(instanceRCV, schemaRCV)**  
  1. Perform a component-wise modulo operation.  
  2. boolean isS \= schemaRCV.s.mod(instanceRCV.s).equals(BigInteger.ZERO);  
  3. boolean isP \= schemaRCV.p.mod(instanceRCV.p).equals(BigInteger.ZERO);  
  4. boolean isO \= schemaRCV.o.mod(instanceRCV.o).equals(BigInteger.ZERO);  
  5. Return isS && isP && isO.  
* **Use Case:** This is a high-speed, purely numerical method for checking type constraints, which can be performed in memory without a complex graph query.

##### Property Chains {#property-chains}

Define composed relations (e.g., knowsLanguage) and leverage reasoners for closure. This section details the specific numerical algorithm for the (:Developer)-\[:worksOn\]-\>(:Project) and (:Project)-\[:usesLanguage\]-\>(:Language) \==\> (:Developer)-\[:knowsLanguage\]-\>(:Language) inference.

* Step 1: Define the Composition Operator  
  compose(RCV1, RCV2)  
  * **Inferred Subject (S\_inferred):** S\_inferred \= RCV1.s \* RCV2.o  
  * **Inferred Object (O\_inferred):** O\_inferred \= RCV1.s \* RCV2.o  
  * **Inferred Predicate (P\_inferred):** P\_inferred \= RCV1.p \* RCV2.p  
* **Step 2: Calculate Schema Archetypes**  
  * The Index Service calculates archetypal RCVs for source schemas:  
    * RCV\_worksOn\_schema \= (S\_wo, P\_wo, O\_wo)  
    * RCV\_usesLang\_schema \= (S\_ul, P\_ul, O\_ul)  
  * It then calculates the archetypal RCV for the inferred schema (knowsLanguage):  
    * S\_kl \= S\_wo \* O\_ul  
    * P\_kl \= P\_wo \* P\_ul  
    * O\_kl \= S\_wo \* O\_ul  
  * This resulting RCV\_knowsLang\_schema \= (S\_kl, P\_kl, O\_kl) is stored.  
* Step 3: The Inference Algorithm at Query Time  
  A user asks: "Does dev:Alice know lang:Java?"  
  1. **Retrieve Instance RCVs:** Retrieve RCV1 for (dev:Alice, :worksOn, proj:Orion) and RCV2 for (proj:Orion, :usesLanguage, lang:Java).  
  2. **Calculate Hypothetical Instance RCV:** RCV\_hypothetical \= compose(RCV1, RCV2).  
  3. **Retrieve Schema Archetype:** Retrieve RCV\_knowsLang\_schema.  
  4. **Perform Numerical Check:** boolean knows \= isInstanceOf(RCV\_hypothetical, RCV\_knowsLang\_schema).  
  5. **Result:** If knows is true, the inference is validated.

##### Querying and Traversal by Numerical Properties: {#querying-and-traversal-by-numerical-properties:}

* **Find by Relational Role:** "Find all entities that have acted as a :Developer".  
  * The query becomes: "Find all statements whose instanceRCV.s component divides RCV\_dev\_schema.s."  
* **Traversal by Numerical Similarity:**  
  * Start at stmt\_A with RCV\_A.  
  * The next step: "Find stmt\_B whose RCV\_B has the highest GCD with RCV\_A."  
  * Allows traversal based on numerically similar relational contexts.

##### Graph Pipeline Specification: CPPE Algebra for Pipeline Stream Actions: {#graph-pipeline-specification:-cppe-algebra-for-pipeline-stream-actions:}

The **Contextual Prime Product Embedding (CPPE)** algebra treats every node in the graph not as a string or a pointer, but as a unique prime number. By leveraging the **Fundamental Theorem of Arithmetic**, relationships and sets are represented as products. This allows the Reactive Stream Pipeline to perform complex graph "joins" and "path traversals" using simple CPU-native arithmetic.

##### 1\. Algebraic Definitions {#1.-algebraic-definitions}

Let ![][image61] be the set of unique Prime IDs assigned to Resource URIs.

For any ContextPoint ![][image62]:

* ![][image63] (The singleton identity).  
* ![][image64] (The cumulative embedding).

### 

###### *The Prime Product Rule:* {#the-prime-product-rule:}

The embedding of a triadic occurrence ![][image65]—where ![][image66] is Context, ![][image67] is Object, and ![][image68] is Attribute—is defined as the product of their respective recursive embeddings:

![][image69]

Because every factor is a prime (or a product of primes), the result is a unique "coordinate" in the integer space that encodes the entire lineage of the relationship.

##### 2\. Pipeline Stream Operators (The CPPE Monad) {#2.-pipeline-stream-operators-(the-cppe-monad)}

In a reactive stream (e.g., Flux\<FCAContextPoint\>), the following algebraic operators are used for "Stream Action":

###### *A. The "Contains" Operator (Sub-graph Filtering):* {#a.-the-"contains"-operator-(sub-graph-filtering):}

To check if a stream of Objects belongs to a certain Context ![][image70] or possesses an Attribute ![][image71]:

* **Logic**: ![][image72]  
* **Reactive Implementation**:  
  // Filter objects that are part of the 'Accounting' context  
  objectStream.filter(obj \-\> obj.getPrimeIDEmbedding().remainder(accountingID).equals(BigInteger.ZERO));

###### *B. The "Intersection" Operator (Aggregation):* {#b.-the-"intersection"-operator-(aggregation):}

To find commonalities between two streams (finding the "Type" or "Concept"):

* **Logic**: ![][image73]  
* **Stream Action**: The Greatest Common Divisor (GCD) of the embeddings of two nodes represents their shared FCA attributes/contexts.  
* **Aggregation Use Case**: When the stream encounters multiple SPO triples, it calculates the "running GCD" of the attributes to infer the Schema (the most specific common super-type).

### 

###### *C. The "Axis Shift" Operator (Alignment):* {#c.-the-"axis-shift"-operator-(alignment):}

Alignment predicts a value for a new context by calculating the "Ratio" of change between existing embeddings.

* **Logic**: ![][image74]  
* **Stream Action**: By dividing by the "Old Axis" prime and multiplying by the "New Axis" prime, we re-project the object into a new coordinate.

##### 3\. Pipeline Stages Revisited via CPPE: {#3.-pipeline-stages-revisited-via-cppe:}

###### *3.1 Aggregation (Algebraic Type Inference):* {#3.1-aggregation-(algebraic-type-inference):}

The Aggregation pipeline consumes raw SPO streams and produces **"Type Tensors"**.

1. **Input**: Stream of rotated triples ![][image75].  
2. **Action**: For all ![][image62] sharing attribute ![][image68], calculate the product ![][image76].  
3. **Inference**: If ![][image64] is divisible by the product of a set of attribute primes, ![][image62] is classified into that Type.  
4. **Complexity**: ![][image77] lookup via modulo instead of ![][image78] graph search.

### 

###### *3.2 Alignment (Vector/Prime Space Prediction):* {#3.2-alignment-(vector/prime-space-prediction):}

Alignment uses the **Prime Ratio** to detect structural similarity.

1. **Input**: Aggregated Types.  
2. **Action**: Map the distance between objects ![][image79] and ![][image80] as ![][image81].  
3. **Discovery**: If ![][image82] and ![][image83] share the same ratio ![][image84], the system aligns them as being "analogous" in different contexts (e.g., "CEO is to Company A what Principal is to School B").

### 

###### *3.3 Activation (State Transition Product):* {#3.3-activation-(state-transition-product):}

Activation is the "Activation Energy" required to move from one prime state to another.

* **Transition Formula**: ![][image85]  
* **Monadic Wrap**: The Occurrence Monad captures the prime state of an actor. When the stream processes a "Role" event, it multiplies the actor's prime ID by the role's prime ID.  
* **Trigger**: If the resulting product matches a known "Success Pattern" (a pre-calculated product of requirements), the **Activation** is fired (e.g., triggering a webhook or a UI change).

## Leverage W3C DIDs (Distributed Resource Identifiers) {#leverage-w3c-dids-(distributed-resource-identifiers)}

**Decentralized Resource Identity**: Uses DIDs and DID Documents as a globally addressable registry mechanism for resources, schemas, Kinds, and service endpoints.

**Contribution to Framework Objective**: Establishes cross-boundary identity, provenance tracking, and capability discovery. Ensures distributed domain services can publish, verify, and synchronize graph state and interaction boundaries securely across administrative boundaries.

Use W3C Decentralized Identifiers (DIDs) as a **distributed semantic registry mechanism** for Resources, Statements, Kinds, Schemas, Contexts and other semantic artifacts participating in the service. A DID provides a stable, globally addressable identifier whose associated DID Document can describe the identity, endpoints, metadata and verification mechanisms required to resolve and interact with the corresponding semantic resource.

Within the proposed architecture, the DID layer acts primarily as a **distributed identity and registry service**, while the TMRM/Base Model remains responsible for representing the semantic graph and its Resource/Occurrence/Statement structures. DIDs can therefore provide a common identity mechanism across independently managed data sources, semantic services and augmentation agents.

The Registry Service could expose APIs/functions such as:

* **Resource registration:** register a semantic Resource and associate it with a DID and its Base Model URI/identifier.  
* **DID resolution:** resolve a DID to its current metadata, semantic endpoints and associated resource information.  
* **Resource discovery:** discover semantic resources, schemas, Kinds, contexts or services by DID, type, capability or semantic relationship.  
* **Identity mapping:** maintain mappings between external identifiers, source-specific URIs and canonical DIDs.  
* **Document/version management:** publish and retrieve changes to the metadata describing a registered resource, supporting versioned semantic definitions.  
* **Verification:** verify the provenance, controller and integrity of registered semantic resources or statements where appropriate.  
* **Service endpoint discovery:** expose the APIs, messaging endpoints or graph services through which a registered semantic resource can be accessed.  
* **Delegation/authorization:** provide a foundation for determining which agents or services are allowed to publish, modify or operate on registered semantic resources.  
* **Provenance and lineage:** associate resources and semantic statements with their originating registries, sources, agents or augmentation processes.  
* **Distributed synchronization:** propagate registry changes through the existing Event Bus so that local indexes and semantic services can react to resource registration, update or removal events.

A DID can consequently serve as the **distributed identity coordinate** for a semantic resource, while the Registry Service maintains the relationship between that identity and the actual semantic graph structures, endpoints and metadata. The Index Service can use these identifiers when maintaining searchable and numerical indexes, including the Prime ID mappings used by CPPE.

This separation allows the architecture to distinguish between **identity, registration and semantic representation**: DIDs identify and locate resources across administrative boundaries; the Registry Service manages their distributed registration and discovery; and the TMRM/Base Model represents their semantic relationships. Augmentation Pipeline agents can then consume resources discovered through the registry and produce Property, Rule and Context Statements as part of the existing Aggregation, Alignment and Activation pipeline.

### **The resulting principle** {#the-resulting-principle}

I would therefore define the architecture as:

> **DIDs identify distributed domain services and advertise their semantic business capabilities. Domain APIs provide the invocation boundary for those capabilities. The semantic graph provides the shared representation of the domain entities and their state. Aggregation, Alignment and Activation determine how a requested business interaction maps onto that semantic graph, while deterministic semantic primitives perform the resulting state changes.**

This is arguably a better match for the document than a purely resource-oriented DID API because the document ultimately aims at **contexts, interactions and executable behaviors**, not merely distributed CRUD over resources.

## Techniques Summary {#techniques-summary}

| Technique | Primary role | Aggregation | Alignment | Activation | Main implementation boundary |
| ----- | ----- | ----- | ----- | ----- | ----- |
| **TMRM** | Semantic graph/metamodel | Resource/Kind structure | Identity/context merge | Semantic substrate | Graph model |
| **Dimensional features** | Axes/order/state | Type/state hierarchy | Ordering/analogy | State transitions | Semantic structure |
| **Formal grammars** | Rules/execution | Infer productions | Match/order productions | Execute productions | Rule model |
| **RDF/RDFS/OWL/SPARQL** | Semantic-web infrastructure | Query/type | Graph/ontology matching | Query/materialize | Graph tooling |
| **Sets** | Algebraic primitives | Intersection/grouping | Inclusion/difference | Candidate sets | Core algorithms |
| **ML/LLMs** | Learned inference | Classification | Clustering | Prediction | Inference helpers |
| **MCP** | Tool/interaction boundary | Discovery | Semantic tools | Invocation | External interface |
| **FCA** | Conceptual inference | Classification | Concept/schema matching | Context vocabulary | Inference engine |
| **CPPE** | Deterministic numerical inference | Algebraic typing | Similarity/alignment | Transition matching | Index/algebra |
| **DIDs** | Distributed identity/registry | Source discovery | Identity mapping | Service discovery | Distributed infrastructure |

Implementation techniques are interchangeable inference and execution mechanisms around a common semantic core. They do not define separate models; they operate on the same Resources, Occurrences, Statements and Kinds, contribute specialized computations to Aggregation, Alignment and Activation, and materialize their results back into the same statement-stream architecture.

# Appendix: Enterprise Scenario: Cross-System Order-to-Delivery Integration {#appendix:-enterprise-scenario:-cross-system-order-to-delivery-integration}

Consider a global manufacturing enterprise operating four distinct systems:

* **CRM (Salesforce):** Manages customer orders and account leads.  
* **ERP (SAP S/4HANA):** Handles billing, general ledger, and invoicing.  
* **SCM / WMS (Manhattan Associates):** Tracks warehouse stock, picking, and shipment logistics.  
* **Project Management (Jira / Asana):** Tracks customer onboarding and post-sale hardware installation projects.

Without a centralized integration model, bridging these systems requires custom point-to-point ETL pipelines or rigid middleware APIs. Below is a concrete walk-through demonstrating how the **Semantic Streams Augmentation Pipeline** acts as an intra-/inter-application integration facade.

## 1\. Raw Source Data Streams (Datasource Ingestion) {#1.-raw-source-data-streams-(datasource-ingestion)}

The integration facade consumes real-time change-data-capture (CDC) events exported into raw RDF Context-Subject-Predicate-Object (CSPO) Quad Statements across all systems:

\# CRM Event Stream (Salesforce)  
(:ctx\_CRM, :Customer\_ACME, :placesOrder, :Order\_1001)

\# ERP Event Stream (SAP)  
(:ctx\_ERP, :Order\_1001, :generatesInvoice, :Invoice\_5001)

\# SCM Event Stream (Manhattan WMS)  
(:ctx\_SCM, :Order\_1001, :dispatchedIn, :Shipment\_9001)

\# Project Management Event Stream (Jira)  
(:ctx\_PM, :Order\_1001, :triggersProject, :Project\_7001)

Every entity is assigned a unique Prime Number ID via the Registry Service to enable algebraic graph transformations (CPPE):

* $primeID(:Customer\_ACME)=3$

* $primeID(:placesOrder)=5$

* $primeID(:Order\_1001)=7$

* $primeID(:generatesInvoice)=11$

* $primeID(:Invoice\_5001)=13$

## 2\. Stage 1: Aggregation Service Agent (Data Layer \- Type & Role Inference) {#2.-stage-1:-aggregation-service-agent-(data-layer---type-&-role-inference)}

### Processing & Inference {#processing-&-inference}

The **Aggregation Agent** consumes raw RDF quads from the messaging stream and performs structural type and role inference using Sets intersections, Formal Concept Analysis (FCA), and Contextual Prime Product Embeddings (CPPE).

By analyzing shared attributes and predicates across the raw streams, it infers the underlying **Kinds** (extensional type definitions):

1. **SubjectKind ($SK$):** Groups entities playing a subject role with shared predicates (e.g., :Customer\_ACME as a CustomerSubjectKind).  
2. **PredicateKind ($PK$):** Grouping of relationship attributes (e.g., :placesOrder and :generatesInvoice aggregated into functional property types).  
3. **ObjectKind ($OK$):** Grouping of target value types (e.g., :Order\_1001 acting as an OrderObjectKind in CRM and OrderSubjectKind in ERP).  
4. **ContextKind ($CK$):** Aggregates overall situational contexts (e.g., SalesOrderContextKind).

Raw SPO Quads ──\> \[Aggregation Agent: Fold\] ──\> Property Quad Statements (Kinds)

### Production Output (Property Quad Statements) {#production-output-(property-quad-statements)}

The agent folds raw statements into **Property Quad Statements** and publishes them to the aggregationProductionTopic:

\# Format: (ContextCK, TypeSK, PropertyPK, ValueOK)  
(:SalesOrderContextKind, :CustomerSubjectKind, :OrderPlacementPredicateKind, :OrderObjectKind)  
(:BillingContextKind, :OrderSubjectKind, :InvoicingPredicateKind, :InvoiceObjectKind)

## 3\. Stage 2: Alignment Service Agent (Information Layer \- Schema Matching & Identity Resolution) {#3.-stage-2:-alignment-service-agent-(information-layer---schema-matching-&-identity-resolution)}

### Processing & Inference {#processing-&-inference-1}

The **Alignment Agent** consumes Property Quad Statements from the Aggregation Layer. Its primary goals are **identity resolution**, **link completion**, and **n-ary dimensional ordering**:

1. **Identity Resolution via CPPE / TMRM:** The agent calculates the Greatest Common Divisor (GCD) of CPPE prime embeddings and inspects ISO TMRM subject proxies across streams. It recognizes that :Order\_1001 in CRM, ERP, SCM, and PM represents the exact same real-world entity, merging these disparate topic proxies into a unified subject.  
2. **Dimensional Axis & State Transition Modeling:** It maps sequential business flow transitions (Previous, Current, Next \- PCN) across dimensions:  
    \$\$\\text{Order Placed (CRM)} \\longrightarrow \\text{Invoiced (ERP)} \\longrightarrow \\text{Shipped (SCM)} \\longrightarrow \\text{Onboarding Started (PM)}\$\$

Property Statements ──\> \[Alignment Agent: Merge & Align\] ──\> Rule Quad Statements

### Production Output (Rule Quad Statements) {#production-output-(rule-quad-statements)}

The agent synthesizes cross-system data into an $N$\-ary reified relationship rule and publishes it to the alignmentProductionTopic:

\# Format: (RelationshipCK, SourceEndSK, MeasurementContextPK, DestinationEndOK)  
(:OrderToFulfillmentRelationshipCK, :CustomerOrderRoleSK, :FulfillmentTrackingPK, :ProjectOnboardingRoleOK)

This single **Rule Statement** links the origin customer order in Salesforce to the active deployment project in Jira across accounting and warehouse steps.

## 4\. Stage 3: Activation Service Agent (Knowledge Layer \- Use Cases & Behaviors) {#4.-stage-3:-activation-service-agent-(knowledge-layer---use-cases-&-behaviors)}

### Processing & Inference {#processing-&-inference-2}

The **Activation Agent** translates structural rules into executable **DCI (Data, Context, Interaction)** patterns. It identifies active business actors, roles, and executable state transitions:

* **DCI Context ($CK$):** :CustomerOnboardingDCIContext

* **Roles ($SK$ / $OK$):** :AccountManagerRole, :ProjectManagerRole, :SystemIntegratorActor

* **Interactions ($OK$):** :TriggerOnboardingProject, :SyncBillingWithShipment

Rule Statements ──\> \[Activation Agent: Activate & Map\] ──\> Context Quad Statements

### Production Output (Executable Context Quad Statements) {#production-output-(executable-context-quad-statements)}

\# Format: (DCIContextCK, RoleSK, ActorPK, InteractionOK)  
(:CustomerOnboardingDCIContextCK, :ProjectManagerRoleSK, :JiraSyncActorPK, :InitiateOnboardingInteractionOK)

## 5\. Unified Contexts & Interactions API (Dynamic Endpoint Execution) {#5.-unified-contexts-&-interactions-api-(dynamic-endpoint-execution)}

The framework exposes a dynamic, discoverable API (such as HAL or Model Context Protocol / MCP) based on the activated knowledge statements. External systems or AI agents interact with this unified facade rather than querying individual backends.

### Architectural Summary Table {#architectural-summary-table}

| Phase / Layer | Input Statement Type | Primary Mechanics | Output Statement Type | Backend Impact |
| :---- | :---- | :---- | :---- | :---- |
| **Ingestion** | Native DB Events / CDC | RDF Quad Serialization | Raw CSPO Quads | Monitors CRM, ERP, SCM, PM. |
| **1\. Aggregation** | Raw CSPO Quads | Sets / FCA Lattices / CPPE Modulo ($O(1)$) | Property Quad Statements | Classifies raw entities into Kinds. |
| **2\. Alignment** | Property Quad Statements | CPPE GCD/LCM, TMRM Identity Merge, PCN Ordering | Rule Quad Statements | Unifies :Order\_1001 across systems. |
| **3\. Activation** | Rule Quad Statements | DCI Context Mapping, Grammar Productions | Context Quad Statements | Exposes cross-system workflows. |
| **API / Execution**  | Context Quad Statements | Dynamic HAL / MCP Endpoints | Synchronized Backend Actions | Updates SAP, Jira, Manhattan state. |

### Execution Flow Example {#execution-flow-example}

1. **Triggering an Interaction:** An Account Manager invokes the :InitiateOnboardingInteractionOK endpoint via the dynamic API.  
2. **State Transition Propagation (Homoiconic Unfold):**  
   * The pipeline unfolds the Context Statement back into its underlying Rule and Property Statements.  
   * The state transition product formula evaluates:  
     $Stat{e}_{new}=Stat{e}_{current}\times primeID(:InitiateOnboarding)$  
3. **Backend Synchronization:**  
   * **SCM (Manhattan):** Updates shipment status to DELIVERED.  
   * **ERP (SAP):** Updates invoice status from PENDING\_DELIVERY to READY\_TO\_BILL.  
   * **PM (Jira):** Creates and assigns the customer onboarding project sprint automatically.

The underlying enterprise applications remain in sync with the integration facade's state flows, operating continuously while the framework provides a single, unified interaction view for all cross-application workflows.

# Appendix: Use Case Discovery and Unified Facade {#appendix:-use-case-discovery-and-unified-facade}

The objective of the Semantic Streams Augmentation framework is not only to integrate heterogeneous datasource models, but to discover higher-level **Contexts and Interactions** that can be exposed as a unified facade over the integrated applications. The source applications remain operational and are synchronized with inferred knowledge and state changes, while the framework provides an integrated semantic and interaction view across their boundaries.

A **Use Case** can therefore be regarded as an inferred `ContextKind` whose participating Resources acquire application-specific `Role`, `Actor` and `Interaction` meanings. Use Case discovery is the process of deriving these higher-level structures from the Property and Rule Statements produced by the Aggregation and Alignment layers.

## Use Case Discovery Pipeline {#use-case-discovery-pipeline}

The discovery process follows the same three-layer Augmentation Pipeline:

Datasource Statements  
        │  
        ▼  
    Aggregation  
        │  
        │  Resource / Kind inference  
        ▼  
Property Statements  
        │  
        ▼  
     Alignment  
        │  
        │  Identity / relationship /  
        │  dimensional / ordering inference  
        ▼  
Rule Statements  
        │  
        ▼  
     Activation  
        │  
        │  Context / Role /  
        │  Actor / Interaction inference  
        ▼  
Context Statements  
        │  
        ▼  
Unified Integration Facade

This corresponds to the existing Agent model in which Aggregation consumes raw RDF CSPO Statements and produces Property Statements, Alignment consumes those Property Statements and produces Rule Statements, and Activation consumes the aligned information and produces Context Statements.

The key distinction is that the output of the pipeline is not necessarily another representation of one datasource. It can be a **new, inferred interaction model spanning several datasources and applications**.

## Intra-Application Use Case Discovery {#intra-application-use-case-discovery}

An intra-application Use Case is inferred when resources belonging to different subsystems of the same application can be connected through shared identities, Kinds, relationships and state transitions.

For example, an enterprise application may contain independent:

Human Resources  
Payroll  
Directory  
Access Control

datasources.

Their source Statements may independently describe:

HR.Employee  
Payroll.EmployeeAccount  
Directory.Person  
AccessControl.Role

Although their source schemas differ, Aggregation can identify recurring Resource Occurrences and infer Kinds such as:

EmployeeSubjectKind  
DepartmentObjectKind  
EmploymentRelationshipPredicateKind  
EmployeeRoleSubjectKind

The current Aggregation model already demonstrates this type of inference for employment, transforming raw `(Context, Subject, Predicate, Object)` Statements into Context, Subject, Predicate and Object Kinds and then into a higher-level Property Statement.

Alignment can subsequently infer relationships between the independently modeled entities:

HR.Employee  
     │  
     ├── Directory.Person  
     │  
     ├── Payroll.EmployeeAccount  
     │  
     └── AccessControl.EmployeeRole

The resulting semantic graph can therefore represent a higher-level concept such as:

Employee  
    ├── identity  
    ├── employment  
    ├── compensation  
    └── accessRole

without requiring the underlying applications to share their internal data models.

Activation can then recognize a Context such as:

EmployeeLifecycle

with Roles and Interactions such as:

Roles:  
    Employee  
    HRAdministrator  
    PayrollSystem  
    AccessControlSystem

Interactions:  
    createEmployee  
    assignRole  
    updateCompensation  
    activateAccess  
    terminateEmployee

The Activation layer is explicitly modeled around Contexts, Roles, Actors and Interactions.

The resulting facade can consequently expose an interaction-oriented API:

GET  /employees/{id}  
GET  /employees/{id}/employment  
GET  /employees/{id}/role  
POST /employees/{id}/change-role  
POST /employees/{id}/terminate

The endpoint does not have to correspond one-to-one with an underlying application endpoint. Its implementation can traverse the inferred semantic structures and invoke the appropriate underlying Resources or application services.

## Inter-Application Use Case Discovery {#inter-application-use-case-discovery}

An inter-application Use Case extends the same mechanism across independently managed applications.

For example:

CRM  
    Customer  
    Opportunity

ERP  
    Account  
    Invoice  
    Payment

Support  
    Customer  
    ServiceCase

The applications may use different identifiers, schemas and relationship structures to describe overlapping domain entities.

Aggregation first derives their local Kinds:

CRM.CustomerSubjectKind  
ERP.AccountSubjectKind  
Support.CustomerSubjectKind

OpportunityPredicateKind  
InvoicePredicateKind  
PaymentPredicateKind  
ServiceCasePredicateKind

Alignment then attempts to establish equivalence, analogy or relational correspondence between these structures.

A possible result is:

CRM.Customer  
      │  
      ├────────── ERP.Account  
      │  
      └────────── Support.Customer

with additional relationships:

Customer ── hasOpportunity ──\> Opportunity  
Customer ── hasInvoice ──────\> Invoice  
Customer ── hasPayment ──────\> Payment  
Customer ── hasCase ─────────\> ServiceCase

The important result is not simply a union of the three source graphs. Alignment produces a semantic structure in which the different source representations become occurrences of a common integrated model.

The proposal explicitly identifies identity resolution and merging as a central requirement, while preserving provenance and contextual information when the same underlying subject occurs in multiple streams.

Activation can then derive a higher-level:

CustomerServiceContext

with:

Roles:  
    Customer  
    SalesRepresentative  
    BillingAgent  
    SupportAgent

Actors:  
    CRM  
    ERP  
    Support

Interactions:  
    viewCustomer  
    createOpportunity  
    issueInvoice  
    recordPayment  
    openServiceCase

The unified facade could consequently expose:

GET  /customers/{id}  
GET  /customers/{id}/opportunities  
GET  /customers/{id}/billing  
GET  /customers/{id}/service-cases  
POST /customers/{id}/open-service-case

The important property is that these endpoints are derived from the **integrated semantic Context**, rather than being a static aggregation of three application APIs.

## Use Case as an Inferred Semantic Contract {#use-case-as-an-inferred-semantic-contract}

A discovered Use Case can be represented as a semantic contract consisting of:

Context  
    Roles  
        Actors  
            Interactions  
                Preconditions  
                State  
                Results  
                Transitions

The Base Model provides the primitive structure from which this contract can be represented using Resources, Occurrences and Statements. Kinds then classify recurring structures, while Rule Statements express the relationships that connect them.

For example:

(CustomerOnboardingContext,  
 CustomerRole,  
 CreateCustomerInteraction,  
 Customer)

can represent a contextual interaction rather than merely an entity relationship.

This follows the document's progression from raw CSPO Statements, through Kinds and Property Statements, to Rule Statements and finally Context Statements.

## Use Case Discovery from Dimensional and State Structures {#use-case-discovery-from-dimensional-and-state-structures}

Use Case discovery can also exploit the dimensional features proposed in the model.

The specification describes relationships in terms of axes, ordering and Previous/Current/Next state structures, for example:

(Unemployed, Employment, Employee)

(Junior, Promotion, Senior)

(Single, Marriage, Married)  
(Married, Divorce, Divorced)

These structures can be interpreted as generalized state-transition patterns.

Consequently, Activation can discover not only static contexts but **behavioral contexts**.

For example:

EmployeeOnboarding

Previous:  
    Applicant

Interaction:  
    Hire

Current:  
    Employee

Next:  
    ActiveEmployee

or:

OrderFulfillment

Previous:  
    CreatedOrder

Interaction:  
    Fulfill

Current:  
    FulfilledOrder

Next:  
    ShippedOrder

Such patterns allow the facade to expose transitions rather than merely CRUD operations:

POST /orders/{id}/fulfill  
POST /orders/{id}/ship  
POST /employees/{id}/activate

The interaction is therefore the semantic representation of a state transition across one or more underlying applications.

## Composite Interactions {#composite-interactions}

An especially important case is an Interaction whose execution spans several applications.

For example:

CustomerOnboarding

may be inferred as:

createCustomer  
    ↓  
verifyIdentity  
    ↓  
evaluateEligibility  
    ↓  
createAccount  
    ↓  
activateAccount

where different steps belong to different underlying applications.

The integration facade exposes:

POST /customer-onboarding

while the Activation layer resolves the contextual execution path:

CRM  
  └── createCustomer

Identity Service  
  └── verifyIdentity

Compliance  
  └── evaluateEligibility

ERP  
  └── createAccount

Access / Service Platform  
  └── activateAccount

The semantic graph therefore becomes the intermediary between **what the integrated system means** and **how its constituent applications implement it**.

This follows the proposal's “code as data” idea: Resources, Statements and Kinds can be applied as templates, transformations and functional compositions, with merge, fold and unfold providing the stream-processing mechanism.

## Unified Read Facade and Unified Interaction Facade {#unified-read-facade-and-unified-interaction-facade}

It is useful to distinguish two levels of facade.

### Unified Resource Facade {#unified-resource-facade}

Provides integrated views of Resources:

/customer/{id}  
/employee/{id}  
/order/{id}  
/product/{id}

These are primarily graph traversal and information integration operations.

### Unified Interaction Facade {#unified-interaction-facade}

Provides contextual operations:

/customer-onboarding  
/order-fulfillment  
/employee-change-role  
/customer-service

These are Activation-level operations whose semantics are defined by Contexts, Roles, Actors, Interactions and state transitions.

This distinction is important because the document's final API concept is explicitly centered on activated Contexts and Interactions, with interfaces rendered over contextual behaviors and role executions.

## Traceability from Facade Interaction to Datasources {#traceability-from-facade-interaction-to-datasources}

Every inferred facade operation should remain traceable to the Statements and Kinds from which it was derived.

For example:

POST /customer-onboarding  
        │  
        ▼  
CustomerOnboardingContext  
        │  
        ├── CreateCustomerRule  
        ├── VerifyIdentityRule  
        ├── CreateAccountRule  
        └── ActivateAccountRule  
                │  
                ▼  
        source Statements  
                │  
        ┌──┼─────┐  
        ▼       ▼        ▼  
       CRM   Identity   ERP

This preserves the central property of the proposal that inferred knowledge is materialized into Statements and propagated through the same stream processing architecture as source knowledge. The pipeline can merge new information with previously known and inferred Statements and then fold or unfold it as required.

The facade is therefore not a black-box orchestration layer. Its operations can be understood as **materialized semantic executions derived from the graph**.

## Datasource Synchronization {#datasource-synchronization}

A write through the unified facade can follow the reverse direction:

Facade Interaction  
       │  
       ▼  
Activation Rule  
       │  
       ▼  
Semantic State Change  
       │  
       ▼  
Underlying Resource Application  
       │  
       ├── Application A  
       ├── Application B  
       └── Application C

The resulting source changes generate new Statements, which re-enter the augmentation pipeline and can update the inferred graph.

This creates a feedback loop:

Sources  
   ↓  
Semantic Augmentation  
   ↓  
Unified Facade  
   ↓  
Interaction  
   ↓  
Source State Change  
   ↓  
New Statements  
   └──────────────→ Semantic Augmentation

This is consistent with the proposal's stated intention that the underlying applications remain operational while reflecting changes made through the integration mechanisms.

## Facade Generation Principle {#facade-generation-principle}

The unified facade can therefore be viewed as a projection of the activated semantic graph:

Resources  
    ↓  
Occurrences  
    ↓  
Statements  
    ↓  
Kinds  
    ↓  
Property Statements  
    ↓  
Rule Statements  
    ↓  
Contexts / Roles / Actors / Interactions  
    ↓  
Unified Integration Facade

The facade is **not another independent domain model**. It is an executable projection of the knowledge inferred by the Augmentation Pipeline.

## Relationship to Implementation Techniques {#relationship-to-implementation-techniques}

The different implementation techniques can contribute at different points in this discovery process:

RDF / TMRM  
    → graph representation, identity, traversal

Sets  
    → exact matching, union/intersection/difference

FCA  
    → concept, Kind and relational-schema inference

CPPE  
    → contextual numerical identity, similarity and traversal

Dimensional Features  
    → axes, ordering and state transitions

Formal Grammars  
    → executable Context/Interaction productions

ML / LLMs  
    → candidate classification, alignment and behavioral inference

DIDs / Registry  
    → distributed Resource and service identity

MCP / APIs  
    → external discovery and invocation of activated capabilities

All of these mechanisms ultimately converge on the same Base Model and the same Aggregation → Alignment → Activation flow rather than producing independent integration artifacts. The proposal explicitly describes the Helper Services as providing functional APIs over the Base Model and allowing techniques such as FCA, CPPE, RDF inference, Sets and ML/LLMs to participate in a common `Resource::apply` composition model.

## Resulting architecture {#resulting-architecture}

The overall result can be summarized as:

         Heterogeneous Applications  
        ┌─────┬─────┬─────┐  
        │ App A  │ App B  │  App C  │  
        └───┬────┴───┬────┘  
                  │           │        │  
            └─────┼──────┘  
                     ▼  
              Source Statements  
                     ▼  
                Aggregation  
                     ▼  
              Property / Kinds  
                     ▼  
                 Alignment  
                     ▼  
              Rules / Relations  
                     ▼  
                 Activation  
                     ▼  
        Contexts / Roles / Actors /  
             Interactions  
                     ▼  
          Unified Integration Facade  
                     │  
          ┌──────────┴──────────┐  
          ▼                                                    ▼  
     Unified Views                    Executable Interactions  
          │                          │  
          └──────────┬──────────┘  
                                     ▼  
                      Source State Updates

This gives the proposal a concrete interpretation of its central idea: **the system does not merely integrate application data; it discovers and exposes the interactions that become meaningful when those applications are viewed as one semantic system.**

**Intra-application use case:** inferred by connecting multiple subsystems/datasources belonging to the same application.

**Inter-application use case:** inferred by aligning corresponding concepts and relationships across different applications.

The following examples are extensions of the proposal rather than use cases explicitly specified in the document.

## 1\. Intra-application: Employee lifecycle facade {#1.-intra-application:-employee-lifecycle-facade}

Imagine one organization's HR application has:

`Employee DB` → employees, positions  
 `Payroll DB` → salary/payroll records  
 `Directory API` → identities, departments  
 `Access-control system` → roles and permissions

The proposal could infer that all four are describing overlapping Resources and occurrences of the same employee.

### What Aggregation discovers {#what-aggregation-discovers}

The Aggregation layer could derive Kinds such as:

`EmployeeSubjectKind`  
`DepartmentObjectKind`  
`EmploymentRelationshipPredicateKind`  
`SalaryMeasurementPredicateKind`  
`EmployeeContextKind`

This is very close to the employment example already in the document, where raw `(C,S,P,O)` statements become Context/Subject/Predicate/Object Kinds and then a property statement such as an employment relationship.

### What Alignment discovers {#what-alignment-discovers}

It could then recognize structures such as:

`HR.employee → Directory.person`

and

`HR.position → AccessControl.role`

and infer relationships such as:

`Employee --hasCurrentRole--> Role`

even when the source systems use different identifiers or intermediate structures.

The document's Alignment layer is explicitly intended for ontology matching, links, attributes, dimensional relationships and ordering.

### What Activation exposes {#what-activation-exposes}

The resulting facade might expose:

GET  /employees/{id}  
GET  /employees/{id}/employment  
GET  /employees/{id}/current-role  
GET  /employees/{id}/compensation  
POST /employees/{id}/change-role

The important point is that `/employees/{id}/current-role` would not necessarily correspond to one backend endpoint. The facade could derive the answer by traversing the integrated semantic graph and then invoke the appropriate underlying system when a state-changing interaction is requested.

That is consistent with the document's idea of dynamic endpoints over Activation-generated Contexts, Interactions, roles and behaviors.

## 2\. Intra-application: Order fulfillment facade {#2.-intra-application:-order-fulfillment-facade}

Consider an application consisting of:

`Order Management`  
`Inventory`  
`Warehouse`  
`Shipping`

Internally they might have quite different models:

Order  
  contains OrderLine

Inventory  
  reserves SKU

Warehouse  
  picks Package

Shipping  
  creates Shipment

### Aggregation {#aggregation}

The framework could infer Kinds around:

Customer  
Order  
OrderLine  
Product  
InventoryReservation  
Package  
Shipment

and recurring relationships such as:

Order \--contains--\> Product  
Product \--reservedBy--\> Order  
Order \--fulfilledBy--\> Package  
Package \--shippedAs--\> Shipment

### Alignment {#alignment}

The interesting inference is that these are not independent concepts but stages of one larger relationship:

Order  
  → Reservation  
  → Fulfillment  
  → Shipment

The dimensional machinery in the document is suited to expressing these as ordered states/transitions, including Previous/Current/Next structures.

### Activation {#activation}

The unified facade could expose a business-level interaction:

Order.fulfill()

rather than forcing a client to know that fulfilling the order requires:

Inventory.reserve()  
Warehouse.createPick()  
Warehouse.confirmPack()  
Shipping.createShipment()

In the proposal's terms, the interaction becomes an inferred Context/Role/Actor/Interaction structure, while the underlying services remain separate.

## 3\. Inter-application: Customer 360 facade {#3.-inter-application:-customer-360-facade}

Now consider two independent applications:

**CRM**

Customer  
Account  
Contact  
Opportunity

**Billing**

Account  
Invoice  
Payment

Possibly also:

**Support**

Customer  
Case  
Ticket

### Aggregation {#aggregation-1}

Each datasource independently produces its own Kinds.

For example:

CRM.Customer  
Billing.Account  
Support.Customer

may have different schemas but overlapping occurrence structures.

### Alignment {#alignment-1}

The Alignment layer could discover a correspondence like:

CRM.Customer  
      ↕  
Billing.Account  
      ↕  
Support.Customer

and merge those identities into one canonical Resource while retaining provenance/context from each datasource.

Identity and merging are explicitly part of the proposed graph infrastructure.

It could then infer a broader relationship:

Customer  
 ├── hasOpportunity  
 ├── hasInvoice  
 ├── hasPayment  
 └── hasSupportCase

### Unified facade {#unified-facade}

A client could ask:

GET /customers/{id}

and receive a semantic aggregate assembled from all three applications.

More interestingly:

GET /customers/{id}/360

could be an **Activation-generated Context** rather than a static CRUD resource.

The distinction matters: the facade represents the **integrated context** rather than exposing three application schemas side by side.

## 4\. Inter-application: University ↔ employment ecosystem {#4.-inter-application:-university-↔-employment-ecosystem}

This one is especially close to examples already present in the document.

Suppose there are:

**University system**

Student  
Program  
Course  
Degree

**HR system**

Employee  
Employer  
Position

The proposal already gives the conceptual example:

> Employee is to Employer in a WorkRelationship as Student is to School in a StudentshipRelationship.

That appears in the dimensional/alignment discussion.

### Aggregation {#aggregation-2}

The framework could derive:

EmployeeSubjectKind  
EmployerObjectKind  
WorkRelationshipPredicateKind

StudentSubjectKind  
SchoolObjectKind  
StudentshipRelationshipPredicateKind

### Alignment {#alignment-2}

It could infer an analogy such as:

Employee : Employer  
     ≈  
Student  : School

That does not mean the two concepts are identical. Rather, their **relational roles are structurally analogous**.

This is exactly the type of dimensional relationship the proposal is trying to materialize through PredicateKinds, axes and comparison encodings.

### Activation {#activation-1}

That could support an interaction such as:

Student.graduate()  
       ↓  
EligibleForEmployment  
       ↓  
Employee.onboard()

The university and HR applications could remain independent while the integration facade exposes an organization-level workflow.

## 5\. Inter-application: Product-to-service lifecycle {#5.-inter-application:-product-to-service-lifecycle}

Imagine:

**PLM**

Product  
Part  
Revision

**ERP**

Product  
PurchaseOrder  
Supplier

**Field Service**

InstalledAsset  
ServiceTicket  
Technician

The semantic graph could discover that:

PLM.ProductRevision  
      ↓  
ERP.Product  
      ↓  
FieldService.InstalledAsset

represents different contextual occurrences of what is effectively the same domain Resource.

### Alignment features {#alignment-features}

This is where the combination of **FCA \+ CPPE \+ dimensional comparison** becomes interesting.

FCA can detect common structural concepts, while CPPE provides numerical contextual signatures for comparison and indexing. The document explicitly proposes FCA for classification/schema inference and CPPE for deterministic contextual similarity and relational inference.

### Unified facade {#unified-facade-1}

Instead of exposing:

GET /plm/products/...  
GET /erp/products/...  
GET /field-service/assets/...

the integration layer could expose:

GET /products/{id}  
GET /products/{id}/revisions  
GET /products/{id}/installed-assets  
GET /products/{id}/service-history

The semantic layer determines which underlying datasource supplies each portion.

## 6\. Inter-application: Lead → Customer → Contract → Service {#6.-inter-application:-lead-→-customer-→-contract-→-service}

This is a good example of an **end-to-end use case discovered across application boundaries**.

Suppose:

`Marketing` owns Leads  
`CRM` owns Customers  
`ERP` owns Contracts  
`Support` owns Service Cases

The applications do not necessarily share a unified model.

The semantic pipeline could discover:

Lead  
  ↓  
Customer  
  ↓  
Contract  
  ↓  
ServiceRelationship

and potentially a higher-level Context:

CustomerLifecycle

### Aggregation {#aggregation-3}

Infer the different entity and relationship Kinds.

### Alignment {#alignment-3}

Resolve:

Marketing.Lead.person  
CRM.Customer.person  
ERP.Contract.account  
Support.Case.account

into a coherent network of Resources.

### Activation {#activation-2}

Expose interactions such as:

customer.convertLead()  
customer.activateContract()  
customer.openServiceCase()

The important shift is that the facade operates at the level of **business interactions**, while the underlying applications remain implementation-specific.

## 7\. Inter-application: Finance reconciliation {#7.-inter-application:-finance-reconciliation}

Consider:

**Sales**

Order  
OrderTotal  
Customer

**Billing**

Invoice  
InvoiceTotal  
Account

**Payments**

Payment  
Settlement  
Account

The framework could infer a common financial process:

Order  
  → Invoice  
  → Payment  
  → Settlement

### Alignment {#alignment-4}

Structural matching could discover:

Sales.Customer  
      ≈  
Billing.Account  
      ≈  
Payments.Account

and dimensional relationships between:

OrderTotal  
InvoiceTotal  
PaymentAmount

### Activation {#activation-3}

The integration facade could expose:

GET  /orders/{id}/financial-status  
GET  /customers/{id}/outstanding-balance  
POST /orders/{id}/settle

The last interaction could activate actions across multiple systems rather than simply reading data.

This fits the proposal particularly well because Activation is intended to move from aligned information into **Contexts, Roles, Actors and Interactions**.

## 8\. A more interesting class: inferred "composite" interactions {#8.-a-more-interesting-class:-inferred-"composite"-interactions}

The most powerful facade feature, conceptually, may not be CRUD aggregation at all.

Suppose the graph has inferred:

Context:  
    CustomerOnboarding

Roles:  
    Applicant  
    SalesRepresentative  
    ComplianceOfficer

Actors:  
    Customer  
    CRM  
    IdentityService  
    ComplianceSystem  
    ERP

Interactions:  
    createCustomer  
    verifyIdentity  
    evaluateCompliance  
    createAccount  
    activateAccount

The facade could expose a single contextual interaction:

POST /customer-onboarding

whose implementation traverses the inferred interaction graph.

The proposal's Activation model is explicitly about discovering **Contexts (Use Cases), Roles, Actors and Interactions**, rather than merely aggregating records.

That makes the facade concept much richer:

> **Data facade:** “give me the integrated customer.”  
> **Interaction facade:** “perform the customer onboarding context.”

The latter is much closer to the stated objective.

## How the pipeline would infer these use cases {#how-the-pipeline-would-infer-these-use-cases}

A useful mental model is:

Datasource A ─┐  
Datasource B ─┼─→ RDF CSPO Statements  
Datasource C ─┘  
                    │  
                    ▼  
             ┌────────┐  
             │  Aggregation │  
             └────────┘  
                    │  
             Resource / Kind  
             inference  
                    │  
                    ▼  
             ┌────────┐  
             │  Alignment   │  
             └────────┘  
                    │  
          identity / relationship /  
          dimensional alignment  
                    │  
                    ▼  
             ┌───────┐  
             │  Activation  │  
             └───────┘  
                    │  
           Context / Role /  
           Actor / Interaction  
                    │  
                    ▼  
          Unified Integration  
                Facade

This corresponds closely to the defined Agent flow:

**Raw RDF → Aggregation Property Statements → Alignment Rule Statements → Activation Context Statements.**

And because the agents operate through merging, folding and unfolding, an inferred higher-level interaction can potentially be traced back to the lower-level Statements that produced it.

## What the unified facade could actually expose {#what-the-unified-facade-could-actually-expose}

I would group the resulting facade features into five categories.

| Facade capability | Example |
| ----- | ----- |
| **Unified Resources** | `/customers/{id}` combines CRM \+ Billing \+ Support |
| **Unified Relationships** | `/employees/{id}/current-role` traverses HR \+ Directory \+ Access Control |
| **Derived views** | `/orders/{id}/fulfillment-status` |
| **Contextual queries** | `/customers/{id}/financial-status` |
| **Executable interactions** | `POST /customer-onboarding`, `POST /employees/{id}/change-role` |

The last category is the architectural payoff: the dynamic API section describes rendering interfaces over **Contexts, Interactions, behaviors, states and role executions**, rather than simply mirroring backend APIs.

# Appendix: ChatGPT Conversation {#appendix:-chatgpt-conversation}

[https\://chatgpt.com/share/6a2c26c5-eab0-83e9-a20b-f4f5807e8e26](https://chatgpt.com/share/6a2c26c5-eab0-83e9-a20b-f4f5807e8e26) 

# Appendix: Gemini Conversation {#appendix:-gemini-conversation}

[https\://share.gemini.google/5jyLb507UYYb](https://share.gemini.google/5jyLb507UYYb)   


[image1]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACgAAAAlCAIAAAC/AjzkAAAB/0lEQVR4Xu2VTasBURjHh4XwAeQDWPoMUhKxYiHZiLBQXlIWLC0U2Up2Ikt2Ft5WsmJPKRtWSnlJecu9T5TGMzP3zFy3ud3u/Hbz/M/MrzPnnOdQH78EhQtiIYlFQxKLxh8Ub7fbZrNZKBTS6XSlUlksFs+o1WrRBrLzHfF0OnW5XBqNJhAIVKvVfr9fLpftdnsul4O0WCxaLBb8DgNh4uv1mkqllEplJBLZ7Xb06Ha7xWIxt9stl8uz2Sw9YkWAGEw2m02hUDQaDZzdORwOWq2WoqjhcIgzBnzFl8vFbDbDR+Hf4oxGKBRSq9Xn8xkHDPiKo9EoWGEhcfAKLLPJZMJVNniJx+OxTCaDpV0ulzh7pVQqZTIZXGWDl9hoNMJ0PR4PDhiMRqPZbIarbJDF8/mcutPtdnH2BmQxtAiwwpaBs4SzNyCLoUuA2GAw4OA9yGKr1QpiOCc4YLDZbHCJG7LY4XCAOJlM4oCB1+s9nU64ygFZDD0SxE6nEwevwB5MJBK4yg1Z/DjEOp0OBzSgUcNhW6/XOOCGLAbC4TBM+ovLDuY6GAxw9Ut4iff7vV6vh3twMpmgCHqZ3+/vdDqoToSXGDgej3Dhq1SqYDBYr9d7vR7cuz6fLx6PC9rMT/iKH6xWq3a7nc/noSHXajV4xCN4I0z8g0hi0ZDEovH/xJ+CoJUQjmgiuQAAAABJRU5ErkJggg==>

[image2]: <data:image/png;base64,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>

[image3]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACgAAAAlCAIAAAC/AjzkAAAB/0lEQVR4Xu2VTasBURjHh4XwAeQDWPoMUhKxYiHZiLBQXlIWLC0U2Up2Ikt2Ft5WsmJPKRtWSnlJecu9T5TGMzP3zFy3ud3u/Hbz/M/MrzPnnOdQH78EhQtiIYlFQxKLxh8Ub7fbZrNZKBTS6XSlUlksFs+o1WrRBrLzHfF0OnW5XBqNJhAIVKvVfr9fLpftdnsul4O0WCxaLBb8DgNh4uv1mkqllEplJBLZ7Xb06Ha7xWIxt9stl8uz2Sw9YkWAGEw2m02hUDQaDZzdORwOWq2WoqjhcIgzBnzFl8vFbDbDR+Hf4oxGKBRSq9Xn8xkHDPiKo9EoWGEhcfAKLLPJZMJVNniJx+OxTCaDpV0ulzh7pVQqZTIZXGWDl9hoNMJ0PR4PDhiMRqPZbIarbJDF8/mcutPtdnH2BmQxtAiwwpaBs4SzNyCLoUuA2GAw4OA9yGKr1QpiOCc4YLDZbHCJG7LY4XCAOJlM4oCB1+s9nU64ygFZDD0SxE6nEwevwB5MJBK4yg1Z/DjEOp0OBzSgUcNhW6/XOOCGLAbC4TBM+ovLDuY6GAxw9Ut4iff7vV6vh3twMpmgCHqZ3+/vdDqoToSXGDgej3Dhq1SqYDBYr9d7vR7cuz6fLx6PC9rMT/iKH6xWq3a7nc/noSHXajV4xCN4I0z8g0hi0ZDEovH/xJ+CoJUQjmgiuQAAAABJRU5ErkJggg==>

[image4]: <data:image/png;base64,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>

[image5]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADQAAAApCAIAAAD1Up35AAADGUlEQVR4Xu2WO0iyURjHJWrRpYZGFyF0aQoaupC21FZj4NCNsoagIoTsQlPRUEKQQwQVFUFEQzSEdFUMF6k0cBClC0WBo13M2/fnfcmOD4q+72sQH+9vCPs/D/jjHM95jiL1h1HQ4C8hy4lFlhOLLCeW/1Hu6elpb29venp6c3MzGAzy4eHhYSKRyGyUhGC5z89Ps9lsMBjW19evrq6Ojo6MRiM+n5yc6HQ62i0NYXIfHx81NTXj4+NkhYaGhlQqVU9PDxtKR5jc4OCgXq9PJpMkf35+VigUGxsbJJeIADmv1wuDtbU1WuAoLy+/u7ujqTQEyM3Pz0Pu7OyMFjgaGxtpJBkBchMTE5AbHR2lBY7t7W0aSUaA3M7OjoKjs7Pz/Pw8Go3SjmIjQO7r66u6upr3A0qlsrW1dXV1tbh3G4sAORAOh7u7u6GVVgQtLS3xeJy2foPremtra3Z21maz3d7e8mGuHy5BmBwPNtThcGA8qNVq3m95eZk2pVKPj49tbW3Nzc24Yq6vr91u98zMzPDwMFybmppodzbEyKWJxWJ9fX2Qa29vJyXoVlZWLi0tkRw3EfonJydJnpWC5LAdfr+fphyBQIDfWTa0WCylpaWXl5dsyIMLvKKi4vj4mBayUZDc1NQUxihNOV5eXiA3MjKSTg4ODpBgB5muDOrq6t7e3miajYLk6uvrXS4XTTmgUlJS4vF4+H+xMBqNBtMCUziz8Qc8EWiUg/xykUikrKxsbm6OFlIpHNLa2tqxsbF0cnp6imUzmUxMl3jyy9ntdnxfVVWVz+djc5zZgYEBTC12kRYXF9GMRx7TKJ78cphakAiFQg0NDXiV7O/vY18WFhbwdkKJ3HD8/L24uGBDlt3dXRrlJr8cnpO8ASaB0+lcWVnBRYAb9f7+nrZ+LzPenrTAgZeVoDdffjlBvL+/a7Xajo4OWuAeql1dXQ8PD7SQmyLLAZxcnFar1crO3Jubm97eXvxlGvNTfDnw+vqKyYGbGUJ4wff39+OwF3i3sfyKXBoIYcTRtGB+V04ispxYZDmxyHJikeXE8g95tsQxY4aCFwAAAABJRU5ErkJggg==>

[image6]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADUAAAApCAIAAAAakPbHAAAC00lEQVR4Xu2WP0jqURTHTRNFRMFBggqnnBq0SfGRIA6GECRCS2CggwpCNIWogQhBY0P+waEGcXAQkTYRHByMIEGkxeBBDYKgIAoaL3/v4A8fdtRn119CxO8znu/96YfLuedeDvW94eDCN4P1YwbrxwzWjxk/y28wGPyZAV76RZD5HR8f7+zsCAQCDocjFou1Wu2vIWq1WqlU6nS6q6urt7c3/BkDyPxoDg4OwO/6+nq8CFt4c3Ozurqq0Wj6/f54xIRF/NbW1sCvVqvhgKIsFgtEFxcXOFgUYr+npycwWF9fx8EQj8cD6d7eHg4WhdgvHA6DwdHREQ6GGI1GSA8PD3GwKMR+8N9gEI/HcUBRzWZTKBRCend3h7NFIfajm+/5+RkHFHV2dgaRz+fDAQPI/Ojm29jYQPVerxcMBkUi0fn5OYoYQuZHN9/W1pZvxMnJidVq3d3ddbvdLy8v+IMhlUolFouFQiEYQPV6HSrv7++FQgGvmwaZH918gUDg9xj/GcjFYlGlUtlstkwmU61Wc7mc3W6/vb11Op1+vx+vngaZH918Dw8POJig0+nArNnc3Mzn8ygCXfgRcEX1qRD40c0nkUjm3rbQjgaDQaFQNBoNnFFUuVzm8/ndbhcH0yDwo5vPbDbjYILT09OVlZXJnaOBrYWbGldnQOBHN9/l5SUOPgL3Ho/HM5lMOBgB2//Jw0ER+dHNd39/j4OPwOmBZclkEgcL8Vm/UqkE/wrPE+gtnH1kf38fVs6aNaTM94PxBu88uVwuk8ngcGxvb+v1+tfXV7xuBDwOuFwuro6RSqVwaTbz/Ujxer2wfzAXcTAknU5Ho1Fcnc3X+8EchldCJBLBAUWBNDx85o6ncb7eD4DbTCqVokOazWYdDker1RovzmUpfsDj4yNMSnhOw73scrnALJFI4EWfYFl+/2i327hEwtL9GML6MYP1YwbrxwzWjxl/Ab0PL+N1mbs9AAAAAElFTkSuQmCC>

[image7]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADgAAAApCAIAAADvbn13AAADVElEQVR4Xu2XXShzcRzHh1ZukIs1kVzsSilq7rY0c8GIC1K7UC5oeb2wS22yTLlwIU1hN+TtQlprKRcoShFFSVLkZYpo3iI2L/Nte+i/3+Y5Z3Y8PU/P+Vz+vr92Pud//m+T+P8RJLTwtyKKCo0oKjSiqND8B6Knp6fj4+NdXV1Wq3V2dvb8/Jx2CMp3RFdXV4uLi8vLyx0Ox8HBwc7OzsDAQFpamsVieX5+pt0CEZ2o1+ttbGyUy+ULCwskOjs7k8lkhYWFb29vJBKEKERvbm40Gk16evrx8THNAoyOjkokksHBQRoIAV9Rn89XUFCQmJi4vr5Osw9ub28hmpqa+vLyQrOY4Sva0tICCZPJRINQMjIy0La3t0eDmOElilGMi4tLSUm5urqiWSi5ubkQnZmZoUHM8BLFEsHj29raaBAGZjA67XY7DWKGW/Tw8FASYHl5mWaheDweDDw65+bmaBYz3KK9vb14Nr475xJxuVzBVzo6OqJZgO3t7eHhYRwQIyMjwQPi9fV1aWmJ9kWCW7S2thbPVqvVNAjDYDCgMz8/nwZ+/8rKSl5eHn7K6XTigJifn6+rq8N21tDQYDabaXckuEWLiorwePwuDUK5v79PSkpCZ39/P6m3trZmZmYuLi6ydf/HEECa1CPCLVpVVYWfMxqNNAjFZrOhTaFQ4PT6LD49PWm12qysrMvLS6b3F1tbW1Kp9OHhgQaR4Bbt7OyEgV6vpwEDJhz2+fj4eLKM8HpYXuFjGQSDrVKpaPULuEWDS0SpVNKAobq6Gj09PT1scX9/PyEhoaSkhC2yYHXyXEl+PqK4ZODwxMBsbGzQLEB3dzcsw9dER0cH6lNTU6T+PbhFAY7E5ORkLPy7uzu2jinY3NyMjz42NsbWg1RUVEDU7XbT4FvwEgUnJyelpaXZ2dm4LO/u7q6trWF/zcnJaWpquri4oN0BdDodZi2tMkxPT9PS1/AVDYItcHJyEt+0r68Pt/rHx0fawdDe3v6bzR+X7qGhIVr9muhEowJvhWthxOsp7GtqajiPOpYfFAU4MHH2kqWNbaS+vv76+potcvKzomBzc7OsrKyyshKzGX9joDgxMUGbePDjop+QHSNa/pxojIiiQiOKCo0oKjSiqNC8A1xthJzJ+s2eAAAAAElFTkSuQmCC>

[image8]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAqCAIAAACGOGTnAAADuklEQVR4Xu2XXShzcRzHR6EooriQosSVdkeRZFwoSUoUZS5HSexCq3mN5ILatAuSUV6StyWklFASuRCikZewJCUvecnL7Pm25TxnP/acs+2cp0fP+VydfX+/s33Pb7////c/MtvPQUaFfxjJqzhIXsVB8ioO/4dXi8UyODjY3Nzc0tIyOzt7eXlJM4TGE69ra2tZWVk5OTkmk+n4+Hhra8tgMERERDQ1Nb29vdFs4XDP68vLS3l5OWzNzc2R0MnJCXSFQvHx8UFCQuGG19vb2/T0dBg6OjqiMTuorkwm6+rqogGB4Ov19fU1LS0tICBgfX2dxj55fHz08fEJDQ19f3+nMSHg67WiogI102g0NOBMVFQU0vb392lACHh53djYQMHCw8Pv7u5ozJmkpCR4nZiYoAEh4OUVK4ZPUUFcXBwyu7u7aUAIuL1igcvs7Ozs0Jgz6Gk/Pz9kTk1N0ZgQcHttb2/Hz0dHR9PAFxYWFhxPdX5+TmN2sOYWFxexXbS2to6Pjz8/P0O8vr7e3t6mqd/B7bW0tBQ/X1hYSANfqK6uRqZcLqcBO319fegQNBLs7u3tYY7k5eUtLy8nJibiIWn2d3B7zczMhIOGhgYacAYjIDY2FpljY2MkhC7ClyQnJ+OCrWOyxMfH+/v7Pz09sXVXcHvNz8+HA71eTwPODAwMIA37ANHhLzIyMjc399vxq9PpUlNTqeoCbq+NjY0wgTMKDbBAYbCz+vr64j9l61arFX8xRt3V1RVbZ5iZmdFqtVR1AbfX6elpeC0qKmKUkZGRmpoao9HIKPX19diAe3p6GMVBf38/7m1rayM6A1bhwcEBVV3A7RWNiOkaFBSE8wA+ohlwAsTF0tLS6OgoLoaGhlBRrG5yI8CNeIaLiwsa8AhurwAzMzg4uKCgAL7VajWjq1Sq2trasLAwNCsr/Te4CwuOqp7Cyys4OzvLzs7GWs7IyDg8PFxZWeno6ECxq6qqmLJhArNPLXiwwMBAzDxGIaCJsX9R1TV8vTrY3d0dHh6uq6vDZo5OwJRibzclJSU3NzesdFtKSkpMTAxbYYO/CBstVV3jnlc2Dw8PWDeTk5OOj1hGxcXFzim23t5e5JjNZqKD+fl5zj2b4K3XkJAQDDbUDzXe3NykSTabUqlMSEg4PT1lFIzWzs5ONLq7bxCee7V9nqoc/OFshdGPDQFVr6ysLCsrw1vQ6uoqTeKBV17xjoA3RMxPNDGNfQFVvL+/p6o7eOX1LyN5FQfJqzhIXsVB8ioOP8nrL9yIdx5psFpDAAAAAElFTkSuQmCC>

[image9]: <data:image/png;base64,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>

[image10]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAqCAIAAACGOGTnAAADuklEQVR4Xu2XXShzcRzHR6EooriQosSVdkeRZFwoSUoUZS5HSexCq3mN5ILatAuSUV6StyWklFASuRCikZewJCUvecnL7Pm25TxnP/acs+2cp0fP+VydfX+/s33Pb7////c/MtvPQUaFfxjJqzhIXsVB8ioO/4dXi8UyODjY3Nzc0tIyOzt7eXlJM4TGE69ra2tZWVk5OTkmk+n4+Hhra8tgMERERDQ1Nb29vdFs4XDP68vLS3l5OWzNzc2R0MnJCXSFQvHx8UFCQuGG19vb2/T0dBg6OjqiMTuorkwm6+rqogGB4Ov19fU1LS0tICBgfX2dxj55fHz08fEJDQ19f3+nMSHg67WiogI102g0NOBMVFQU0vb392lACHh53djYQMHCw8Pv7u5ozJmkpCR4nZiYoAEh4OUVK4ZPUUFcXBwyu7u7aUAIuL1igcvs7Ozs0Jgz6Gk/Pz9kTk1N0ZgQcHttb2/Hz0dHR9PAFxYWFhxPdX5+TmN2sOYWFxexXbS2to6Pjz8/P0O8vr7e3t6mqd/B7bW0tBQ/X1hYSANfqK6uRqZcLqcBO319fegQNBLs7u3tYY7k5eUtLy8nJibiIWn2d3B7zczMhIOGhgYacAYjIDY2FpljY2MkhC7ClyQnJ+OCrWOyxMfH+/v7Pz09sXVXcHvNz8+HA71eTwPODAwMIA37ANHhLzIyMjc399vxq9PpUlNTqeoCbq+NjY0wgTMKDbBAYbCz+vr64j9l61arFX8xRt3V1RVbZ5iZmdFqtVR1AbfX6elpeC0qKmKUkZGRmpoao9HIKPX19diAe3p6GMVBf38/7m1rayM6A1bhwcEBVV3A7RWNiOkaFBSE8wA+ohlwAsTF0tLS6OgoLoaGhlBRrG5yI8CNeIaLiwsa8AhurwAzMzg4uKCgAL7VajWjq1Sq2trasLAwNCsr/Te4CwuOqp7Cyys4OzvLzs7GWs7IyDg8PFxZWeno6ECxq6qqmLJhArNPLXiwwMBAzDxGIaCJsX9R1TV8vTrY3d0dHh6uq6vDZo5OwJRibzclJSU3NzesdFtKSkpMTAxbYYO/CBstVV3jnlc2Dw8PWDeTk5OOj1hGxcXFzim23t5e5JjNZqKD+fl5zj2b4K3XkJAQDDbUDzXe3NykSTabUqlMSEg4PT1lFIzWzs5ONLq7bxCee7V9nqoc/OFshdGPDQFVr6ysLCsrw1vQ6uoqTeKBV17xjoA3RMxPNDGNfQFVvL+/p6o7eOX1LyN5FQfJqzhIXsVB8ioOP8nrL9yIdx5psFpDAAAAAElFTkSuQmCC>

[image11]: <data:image/png;base64,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>

[image12]: <data:image/png;base64,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>

[image13]: <data:image/png;base64,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>

[image14]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAF4AAAAtCAIAAACoBktWAAAGhElEQVR4Xu2Ye0gVWxSHT2VBhRYGQVQQ9ITsSdCTykwtoYdmlNHLnhZiJiWIBaFFWRZFQZhBEKk9/ygIiqIHPaisTMgsizI0raDMSk17zP2YuecwZ53Z54wX7r0I8/0R+Vv7zMz+zd5rrT0uzUGBSwoObhxrlDjWKHGsUeJYo8SxRoljjRLHGiWONUranjX3798/dOiQVNW8efMmKyvrz58/MhCIf2hNY2PjyZMnV69enZiYuGjRos2bN587d87P7VtaWq5fv3779u0HDx48fvyYf/k/kzSPqa+vZ8zdu3cfPXpEqKSkxBw14IcTJkzg7jLgl/z8/OTkZKkGotXWMMndu3cPGjSIfz9//myIZWVlU6ZMmTZtWmVlpffwv/nw4cOWLVvWr1/foUMHl8sVFhaWlpa2b98+85gXL16MHz+eaKdOnSIjIw8ePGiOQm1t7ZAhQxgmdDssXbo0Ly9Pqn5pnTXMfNiwYZMnT+YpRejnz58jRozo06fPt2/fRMhDQ0NDUFAQk3/+/LmM6axdu3b+/Plv376VAZ2EhARfv2xSV1fXq1evd+/eyYCaVlhTWlrK1SdNmtTc3CxjOjdu3GDaGzdulAE3V65cYQArTgY07cePH5s2bWKTyoCbO3fudO/e/fv37zJgGx5s8eLFUlVj15r379+zInr37s3WkDE3TI/9wrpoamqSMZ3MzEysIUMJnUy5fPnyiooKoZuZM2cOe1CqrYHF2LFjR/sLx641pBJmdfToURnwZuDAgQwj0cqAzsSJE4kWFBSYxYsXL27YsIG9ZhYFvA8cf/jwoQy0ErLB9u3bparAljWsc6bUv39/EoqMeTN06FBGHj9+XAb0RMNLI1pdXW0ov3//zs7OPnLkiPdAC44dO9a5c+eAd//69WtxcXF5eTlXljEd6sC4ceOkqsCWNcZa2Llzpwz4EBoaqrLGSDQDBgww/vz48WNERERubq73KGtWrFjBipOqCUxZuXLl7NmzufWBAweGDx9+/vx5OUjTCgsLWX02E1Zga2glXDrPnj2TMW9IGcZI2hMZcycaJqDpOZW3x580KXKcFQyjeEnVDR0QL8+8U27evEnW893X9+7d46asLKFbEtga+hEuR22SAR9OnDjBSHaNp98xYyQa3ioFeO/evZR/+hebD8pay8jIkKoOaahHjx4LFy4UeteuXePj44VIpueOp0+fFrolga3hrlwuOjpaBnyYNWsWI2fOnCkDpkQzd+7ca9euGeKSJUtQ7BTUkJCQXbt2SVUnNja2ffv2r1+/Fnq3bt1YSkL89OkTdzx8+LDQLQlszdSpU7ncunXrZMAbkqvR6V64cEHG3ImG8u/JwUDFMVZZTU2NaayE7Mswy3OT0UlRPYVOq4Her18/oRuX2r9/v9AtCWwNLTaXo77KgDc0VAwLDw+XAR0j0fjmC5II+tatW4UuaNeuHecSqWpaamoqP/ddUGfOnEGPiYkR+pcvX1yKKuFLYGv27NnD5ei4ZMAEB0KWDN2qqm0zEk1RUZHQT506hd6zZ0/aRREyQ+HDXKlqGiWJn3t2qNDJfUKn60O/dOmS0C0JbA1pkpdGU6M6WNP7jho1iqJ4+fJlGdPxJBrLkxe7jBCdiwiZGT16dFJSklT1os5vX758aRaN/pD16/vA1DKXuiMVBLYG1qxZwxXPnj0rA/rhgOwbHBys8kVzJ5rBgwfLgM6OHTuIjhw5UgZMLFu2zLLM053zW0qyWUxOTiZt00mYRQPWEaubJkgGrLBlDVt0zJgxffv25YRp1p8+fcr75MBZVlZm1j2wKGjtOEwzAfYUzyTeJM6SKVw6NCacj81RD/n5+V26dPn165fQUXgATwqjCc7KysJl1ck+JSWFiUhVgS1rNP0hSITk/FWrVlH8cnJyyD4zZszw0yOwzul3GcPIuLg4FldUVBRbwDMA44jSFpAaqMFkzenTp1v2RFVVVVRoy49b2E315HTKtLkR1vhJW2PHjt22bZtUFdi1xgOFlrT35MmT+vp6Gfs3wTj/J2/fzCJ49eoVOUj1sc2XVlvzf3H16lXqlOpzhx1wdsGCBVJV02asgXnz5tk5plvCvuOso/p+aElbsoaMw2GKfSEDNkhISOBELlW/tCVr4NatW1Rx1RdYFXl5eYmJiVINRBuzRtPPTTYPQQacPNPT01Uft/zQ9qz5z3CsUeJYo8SxRoljjRLHGiWONUoca5Q41ihxrFHyFyiiXWOqOun0AAAAAElFTkSuQmCC>

[image15]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADEAAAApCAIAAAATe1a9AAACUklEQVR4Xu2WS8tpURjHt3cgfAD5AIY+g5RELgPKJQYiJOWSMmBooFwGJpKZyJCZgdtIMmBOlAkjpVxSbjnnyVvaHh32fs/ZpdP+jeznv2y/lrWetYhfnweBCx8A60QN1okarBM1/i+nzWZTq9UymUwsFisWi/P5/B7V63XSQNr8xGk8HptMJqFQ6HK5SqVSp9MpFAoajSaZTEKay+WUSiX+Dh3oOV0ul2g0yuPx/H7/drslR9frNRgMWiyWr6+vRCJBjuhCwwkk1Go1l8utVqs4u7Hf70UiEUEQvV4PZ3Sg6nQ+nxUKBfwe/Fk4I+HxeAQCwel0wgEdqDoFAgEQgkWDg0dgScnlclylCSWn4XDI4XBgGS0WC5w9ks/n4/E4rtKEkpNMJoNJslqtOHhiMBhMp1Ncpcl7p9lsRtxotVo4Y4b3TtAVQQhWLjQCnDHDeydojOAklUpxQIHj8ZjNZtPpNA5e8t5JpVKBE2xyHDyxXq/vn/v9vtlsht0KHcvr9ZJGvee9k16vB6dIJIKDJ+x2O0wMKkokkn/vBIcJOBkMBhw8AlshHA7jKkNO381JLBbjgAQcdtApVqsVDhhyAnw+H0zVixsIzFC328XVG0w57XY7eDVcTkajEYqgszudzmaziep3mHICDocD3N34fL7b7a5UKu12G+5JDocjFAqRt9szDDp9s1wuG41GKpWCQ61cLsMjHvEE404/4OOc4DiCngkdDgcvYcppMpnAajMajTqdTqvV2mw2eMSD/gBTTn8D60QN1okarBM1WCdqfKLTb8rtg7tH+EZcAAAAAElFTkSuQmCC>

[image16]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADEAAAApCAIAAAATe1a9AAAC6UlEQVR4Xu2Wy0syURiHrUWo2yBatBIFF/0LiZGR6MrAiDZRlmTQhaBFLVq0CCyXiTfISFxWtGjRxU1RLmpRmwqCNrZRMbpJXsq+H8k3Ta+XOdOHIB/zrGbe3/HM48yc94zss/6Q0UIdIDmxITmxITmx8X85PT09bW1tuVyu+fn59fX1WCzGRbu7u7yBovmN083NTV9fX0tLy8jIyMbGRiQS8fl8ZrPZ6XQidbvdPT099DdiEOf0/v4+Nzcnl8snJiaen5/5UaFQmJqa6u/vb2xsXFpa4kdiEeEECZPJ1NTUtLm5SbMv0ul0a2urTCY7OTmhmRhYnfL5fHd3N66Hh0UzHna7XalU5nI5GoiB1WlychJCeGlo8BO8Ul1dXbQqEian8/PzhoYGvEb39/c0+4nH41lcXKRVkTA56fV63KSBgQEalHB2dnZ7e0urIhF2uru7k31xcHBAs9og7ISuCCG8uWgENKsNwk5ojHDS6XQ0EAL31WazoWNZrdZwOPzx8UFHVEDYyWg0wgmLnAYlPD4+csfo5qurq8WmcHl52dbWZrFY0Fe/R1dG2AlzwWl2dpYGJQwODmaz2c+vZqZSqU5PT7lobW0Nk+zs7HyProywEzYTTNfb20uDn2ApzMzMFI/j8Th2GIfDwaUXFxeYZGFhgatUQdip2JzUajUNeOChoFOkUimucnV19fr6yp1ub2/DKRgMcpUqCDuB8fFxzFjlCwR36Pj4mFZ5GAwGjUbz9vZGg3IwOb28vLS3t+Pj5Pr6mkTo7MPDw/v7+6TOZ2VlRavVCu4BHExOIJPJ4NtNoVCMjo5iYR8eHmJlDQ0NTU9P85dbKXheHR0diUSCBpVhdSqCqff29paXl7GphUIhwSsFAoGxsbFiR8C/ikajdEQ5xDmJwu/3Yw/gTo+OjrxeLy+vSK2c8GSbm5sNf+ns7ETbhBYdV46aOCWTSX05Hh4e6NBy1MTpH5Gc2JCc2JCc2JCc2KhHpz8T9GWRh+RmJgAAAABJRU5ErkJggg==>

[image17]: <data:image/png;base64,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>

[image18]: <data:image/png;base64,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>

[image19]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACcAAAAlCAIAAABOCWdpAAABtklEQVR4Xu3Vv6tBcRjH8ZNRJJv1mAwKo6xyZFMWGRRZDBaLZFDOaDtZGPwDMvkDbslgMFgMyiqRMkny435y6nbuc++Dc9xzb7fOe+L7PHqd8g3h+hcJ9OBXslSzs1Sz+7fq+XxOpVKz2YwO+H5AbbVagiD0+3064HtV3Ww2brcbKmw643tVLRQKgUAAaq1WozO+l9TxeAy1Wq1CzefzdMxnXMUlisVi6/VaURSoiUSCbvAZV9vttvpd9no9qKFQiG7wGVS32200Gj2dTng9Go2gejweusRnUC0Wi8DU14vFAqrNZlMf4pmMqJPJJJfLfbzd7/fCreVyqdm6l271crnE4/HVaqU9dLlcUPE02sM76Va73W4wGKx8TlUHgwHdZtKn7nY7SZLevoQLDLXT6dAPMOlTS6XScDikp9drOp2G2mg06IBJhzqdTrPZLD29VS6XoeJi0wHTs+rxeIxEItwtbTabUJPJJB0wPaXixuIf1Ov14leQzm7JsgzV5/PRAdMD9XA4hMNhh8OBvzO73S6K4nw+1y7U63W/368uOJ1OXO9MJqNd+LYHqklZqtlZqtlZqtm9A49eHwXIguU5AAAAAElFTkSuQmCC>

[image20]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACkAAAAlCAIAAABQwFfaAAAB/ElEQVR4Xu2WzcthURyAbxElWbLysfGdFBsxdjb2xIqNhY9kZ42Shc3YK2VFWPgH7ISUZGlDekMWdlKanPl1T29Nv5zXnKm509R9lue55zxdv9x7BfLvEPCChMht6ZHb0vNftX8weD6f+NJ38LVzuZzP51Or1YIg6HS6YDD4TSQUClmtVrfbXSqVTqcT3saAr01JJpPQ7na7aH0ymWg0Gr1efzgckHrJn7TNZjO0j8cjFoRks1lQmUwGi1dwt3e7HZzucDiwEKlUKmDD4TAWr+BudzodOB3uDwuRaDQKtlwuY/EK7nY6nYbTe70eFoRMp1OlUmkwGPb7PXav4G6zhr1arUwmk8ViWS6XSLHga9NhQ+Djk+12OxqNCoWCx+OpVqu32w3vYcPXpsOORCLff6FWq8VisXg8Ph6P8YYv4WvTYQ+HQywIaTaboIrFIhZs+Np02JfLBQtCHo8HPOnAzudz7BhwtOmwXS4XFp8YjUa4oNVqYcGAo02Hnc/nsRCBH0MQGQwG2DHgaNNh9/t9LEQajQb9C9zvd+wYcLTpsM/nMxaELBYLlUql1Wo3mw12bH63vV6vIWy329H69Xqt1+sQ9nq9s9kM2a95306lUn6/H16O0FYoFIFAgL6zAZvN5nQ6E4lEu92Gzwe88x3v238PuS09clt65Lb0/AQEErVT4CAEyQAAAABJRU5ErkJggg==>

[image21]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFMAAAAtCAIAAABd+MDmAAAEcElEQVR4Xu2YWSh1XRjHD1EUZSZTrkRcoJRcvZkyJiWhTCkpF8osX5KiTkKUpFwonwwXLlwYv8hQik6+yBCSkCGFzJn292/vvB3P2eucfY7jPV/t87s6nv/aPeu/93rWehYFJ1cUNCAbzM7lh9m5/DA7lx9m5/LDOM5fXl5oSAOVSlVWVkajpsMIzm9ubjw9PZeWlqjwlcvLSwcHh/v7eypI5vj4+B8G8/PzR0dHHx8f9Bk2RnBeWlqqUCgGBwepoEFKSkp/fz+NSmZiYqKqqioyMhLpXFxcKisr//qkuLg4ICDA3d29o6ODPsbgu87X19etrKwwlfb2dqppMDw8HBcXR6N60tbWhnR4BSSOiktMTITU3NxMJFG+6xzJkpKSRKeiydPTk5OT0+npKRX0ITU1FekmJyepwHFTU1PCcqCCGN9yPjAwoFQqGxoakC8nJ4fKYhQWFra2ttKoZN7f3x0dHbHK7u7uqMZx4+PjmImtra2UHddw57e3t1FRUcjR09ODfDExMXSEGHNzcyEhITQqmbW1NeSKiIigAg8qH2pCQgIVxDDceUVFxfT0NH6MjY0hX1BQEB0hBrZfHx+fjY0NKkgDuwly1dTUUIHfcWxsbFBNe3t7VBPDQOdbW1tZWVnC79XVVcwGKb8OYYJ5V1dX06g0WEU+MzPj6+sbGhqKRUEkFgY6x/mE81P4fXJyouB5fn7+Okqczc1Nb29vVCwVdCEUORJ1d3f/zdPX11dbW4tCwxvBsfr29kafYWOI85GRkaampt9/vr6+WlhYYEKHh4dqo7QRFhY2OztLo7oQijw8PPxfNVZWVnp7e/G109LSDg4O6DNs9HaOJgwbG/m8rq6umNPy8rJ6UAs4kwsKCmhUF0KR19XVUYFvEO3t7VFxWIBUY6C3c6wuLy+viK9ga8GcRkdH6WgGZ2dnWLePj49U0IpQ5ChpKvBkZGRAxb5LBQb6Od/d3c3OzqZRjouNjUXWrq4uKrCJj48fGhqiUTZCkVtbWz88PFCNJz09HXPA26ECA/2co5ZEizk/Px9Z0T9TgQ32JzR/NMpGKHI07VT4BIclBtTX11OBgR7OsZgbGxtplAclgKzoz6jABp8OV7eLiwsqMBCKHImowINNDiqujOfn51RjINU5phgYGIjGmwo8uCEhMXp4KmgFDW9nZyeNMhCKHJ05FTgOV1Rsb2ha0VlQjY1u59fX17hj+fv7u7m57e/vExU9GW4geXl5mJaHhwdekPSDGi0gjiga1QCvW6VS2dnZKfiD8+2Tq6sr3MxLSkosLS1xBdze3qZPakWHc5xeaINRkKhwfNLo6GhscuoDsP6xvSUnJ2MA2hvMIDc3V32AFvCOsD53dnaooAYW+S82WDUtLS0LCwv0MQnocP7TlJeX67UvGhETO0cT5ufnp9d/kYyFiZ2D4ODgxcVFGv15TO9cqVQWFRXR6M9jeufotJ2dnSXe84yI6Z2DzMxMcmT8Af4Xzk2C2bn8MDuXH2bn8sPsXH7I1/l/usmTaOLudIQAAAAASUVORK5CYII=>

[image22]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACcAAAAlCAIAAABOCWdpAAABtklEQVR4Xu3Vv6tBcRjH8ZNRJJv1mAwKo6xyZFMWGRRZDBaLZFDOaDtZGPwDMvkDbslgMFgMyiqRMkny435y6nbuc++Dc9xzb7fOe+L7PHqd8g3h+hcJ9OBXslSzs1Sz+7fq+XxOpVKz2YwO+H5AbbVagiD0+3064HtV3Ww2brcbKmw643tVLRQKgUAAaq1WozO+l9TxeAy1Wq1CzefzdMxnXMUlisVi6/VaURSoiUSCbvAZV9vttvpd9no9qKFQiG7wGVS32200Gj2dTng9Go2gejweusRnUC0Wi8DU14vFAqrNZlMf4pmMqJPJJJfLfbzd7/fCreVyqdm6l271crnE4/HVaqU9dLlcUPE02sM76Va73W4wGKx8TlUHgwHdZtKn7nY7SZLevoQLDLXT6dAPMOlTS6XScDikp9drOp2G2mg06IBJhzqdTrPZLD29VS6XoeJi0wHTs+rxeIxEItwtbTabUJPJJB0wPaXixuIf1Ov14leQzm7JsgzV5/PRAdMD9XA4hMNhh8OBvzO73S6K4nw+1y7U63W/368uOJ1OXO9MJqNd+LYHqklZqtlZqtlZqtm9A49eHwXIguU5AAAAAElFTkSuQmCC>

[image23]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACkAAAAlCAIAAABQwFfaAAAB/ElEQVR4Xu2WzcthURyAbxElWbLysfGdFBsxdjb2xIqNhY9kZ42Shc3YK2VFWPgH7ISUZGlDekMWdlKanPl1T29Nv5zXnKm509R9lue55zxdv9x7BfLvEPCChMht6ZHb0vNftX8weD6f+NJ38LVzuZzP51Or1YIg6HS6YDD4TSQUClmtVrfbXSqVTqcT3saAr01JJpPQ7na7aH0ymWg0Gr1efzgckHrJn7TNZjO0j8cjFoRks1lQmUwGi1dwt3e7HZzucDiwEKlUKmDD4TAWr+BudzodOB3uDwuRaDQKtlwuY/EK7nY6nYbTe70eFoRMp1OlUmkwGPb7PXav4G6zhr1arUwmk8ViWS6XSLHga9NhQ+Djk+12OxqNCoWCx+OpVqu32w3vYcPXpsOORCLff6FWq8VisXg8Ph6P8YYv4WvTYQ+HQywIaTaboIrFIhZs+Np02JfLBQtCHo8HPOnAzudz7BhwtOmwXS4XFp8YjUa4oNVqYcGAo02Hnc/nsRCBH0MQGQwG2DHgaNNh9/t9LEQajQb9C9zvd+wYcLTpsM/nMxaELBYLlUql1Wo3mw12bH63vV6vIWy329H69Xqt1+sQ9nq9s9kM2a95306lUn6/H16O0FYoFIFAgL6zAZvN5nQ6E4lEu92Gzwe88x3v238PuS09clt65Lb0/AQEErVT4CAEyQAAAABJRU5ErkJggg==>

[image24]: <data:image/png;base64,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>

[image25]: <data:image/png;base64,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>

[image26]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACcAAAAlCAIAAABOCWdpAAABtklEQVR4Xu3Vv6tBcRjH8ZNRJJv1mAwKo6xyZFMWGRRZDBaLZFDOaDtZGPwDMvkDbslgMFgMyiqRMkny435y6nbuc++Dc9xzb7fOe+L7PHqd8g3h+hcJ9OBXslSzs1Sz+7fq+XxOpVKz2YwO+H5AbbVagiD0+3064HtV3Ww2brcbKmw643tVLRQKgUAAaq1WozO+l9TxeAy1Wq1CzefzdMxnXMUlisVi6/VaURSoiUSCbvAZV9vttvpd9no9qKFQiG7wGVS32200Gj2dTng9Go2gejweusRnUC0Wi8DU14vFAqrNZlMf4pmMqJPJJJfLfbzd7/fCreVyqdm6l271crnE4/HVaqU9dLlcUPE02sM76Va73W4wGKx8TlUHgwHdZtKn7nY7SZLevoQLDLXT6dAPMOlTS6XScDikp9drOp2G2mg06IBJhzqdTrPZLD29VS6XoeJi0wHTs+rxeIxEItwtbTabUJPJJB0wPaXixuIf1Ov14leQzm7JsgzV5/PRAdMD9XA4hMNhh8OBvzO73S6K4nw+1y7U63W/368uOJ1OXO9MJqNd+LYHqklZqtlZqtlZqtm9A49eHwXIguU5AAAAAElFTkSuQmCC>

[image27]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACkAAAAlCAIAAABQwFfaAAAB/ElEQVR4Xu2WzcthURyAbxElWbLysfGdFBsxdjb2xIqNhY9kZ42Shc3YK2VFWPgH7ISUZGlDekMWdlKanPl1T29Nv5zXnKm509R9lue55zxdv9x7BfLvEPCChMht6ZHb0vNftX8weD6f+NJ38LVzuZzP51Or1YIg6HS6YDD4TSQUClmtVrfbXSqVTqcT3saAr01JJpPQ7na7aH0ymWg0Gr1efzgckHrJn7TNZjO0j8cjFoRks1lQmUwGi1dwt3e7HZzucDiwEKlUKmDD4TAWr+BudzodOB3uDwuRaDQKtlwuY/EK7nY6nYbTe70eFoRMp1OlUmkwGPb7PXav4G6zhr1arUwmk8ViWS6XSLHga9NhQ+Djk+12OxqNCoWCx+OpVqu32w3vYcPXpsOORCLff6FWq8VisXg8Ph6P8YYv4WvTYQ+HQywIaTaboIrFIhZs+Np02JfLBQtCHo8HPOnAzudz7BhwtOmwXS4XFp8YjUa4oNVqYcGAo02Hnc/nsRCBH0MQGQwG2DHgaNNh9/t9LEQajQb9C9zvd+wYcLTpsM/nMxaELBYLlUql1Wo3mw12bH63vV6vIWy329H69Xqt1+sQ9nq9s9kM2a95306lUn6/H16O0FYoFIFAgL6zAZvN5nQ6E4lEu92Gzwe88x3v238PuS09clt65Lb0/AQEErVT4CAEyQAAAABJRU5ErkJggg==>

[image28]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFwAAAApCAIAAAA3Ytl9AAAEQklEQVR4Xu2YWyi1WRzGN+VG5HBDEW0XGlEO7XIaQkIUqX3hVERy+lJyYZxK4YLIxMhEOZRTiBv2lYspEUnigkFS+hI2ETl/7O/pfRvt+b/r3WdMzfpd8X/Wai3PWu+z1qLQcSQoaIHDTWHCTWHATWHATWHATWHATWHATWFgA1NeX1/VavXOzg4VPpe3t7cfMtCmxrCBKb29vQqFYnZ2lgqfyP39fXx8fGBgoELA29s7Ojr6V4Hw8HClUqlSqbq6uh4eHmhPFtaaotVq3dzcMA9YQzVjYA3Hx8fz8vIiIiJ+YVFbW0v7GMPT0xOTOT4+JvX29nbUY2Njn5+fiSTFWlOKi4uDg4MxXkNDA9UMsr6+HhYWFhcX19raurCwgK/vbwlXV1e0m0GOjo4wE7hJBYGAgACoo6OjVJBglSlra2swpa6uDoMVFRVRWZ6xsTEvL6/JyUkqWMfQ0BBmUlpaSgUBLADUxsZGKkiw3BTka1JS0vn5eU9PDwZLTU2lLWQ4ODjw8PDY3d2lgtXk5+djJkyv8ak6OztD1Wg0VJNguSn9/f1ijszMzGCw0NBQ2kKGqKgo9KVVW+Dr64uZnJycUEGna2tr+/BMuby8TExMFE+75eVljIeEo41Y7O3t4WjA8UkFqzEQKBMTEw4ODnDk4uKCaiwsNKW8vBxeiD8fHh5iNvb29qbcCDC/rKwsWrUFYqBkZ2d//4etra3h4eH09PSYmJiRkRHaQR5LTNnY2CgsLHz/FXcEhQBz3xL6+vrKyspo1RaIgYKU/V2PmpqatLQ0nAbb29u0gzxmm4Kdn5KScnp6ql90cXHBhGCWfpHJ3Nwclo5WbQECxc7ODsFP6i8vLxkZGfh8mAHMxGxTsEtDQkJ++zeiKfPz87S1BEwal727uzsqWIcYKLjRUkFgdXUVKib59PRENRbmmXJ9fZ2cnPyXBBw9GHVgYIB2YFFQUFBRUUGr1iEGCpKOCgJi6gGkDNVYmGdKZWXl0tISrep0iDcM2dzcTAUWt7e3/v7+tn0riYEyNTVFBYHp6WmFcBScnZ1RjYUZpsBmjE2rAtXV1QYWSsrm5qaPj09JSQm2HtUsQryhkKR7ByEI1fRTz1RTcOfBu1PufOno6MComZmZVJAH+6Wqqsrd3T0hIQE/dHd3/yGBuSuliIGCpw0VBPA4hhoUFHRzc0M1GUwyBSugVqv9/PxwtaeaQEtLi0Lm4mQY3CYGBwfr6+u/sTDl8QZw9GJ07DtSh1k5OTniamEgohrAiCmPj4+RkZFOTk44MhwdHZVK5f7+vn6DpqYmLILYAI8LHEy5ubn6DT4OrVaLNx5GR1jgL3d1dX3/HwpeEvigVCoVnqmLi4u0pzGMmPL/hJvC4AtM6ezspOEhg4mZYnO+wBSNRvOnaaysrNDOn8IXmPLfh5vCgJvCgJvCgJvCgJvCgJvCgJvCgJvCgJvC4CcCBrhn9/n0+AAAAABJRU5ErkJggg==>

[image29]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACcAAAAlCAIAAABOCWdpAAABtklEQVR4Xu3Vv6tBcRjH8ZNRJJv1mAwKo6xyZFMWGRRZDBaLZFDOaDtZGPwDMvkDbslgMFgMyiqRMkny435y6nbuc++Dc9xzb7fOe+L7PHqd8g3h+hcJ9OBXslSzs1Sz+7fq+XxOpVKz2YwO+H5AbbVagiD0+3064HtV3Ww2brcbKmw643tVLRQKgUAAaq1WozO+l9TxeAy1Wq1CzefzdMxnXMUlisVi6/VaURSoiUSCbvAZV9vttvpd9no9qKFQiG7wGVS32200Gj2dTng9Go2gejweusRnUC0Wi8DU14vFAqrNZlMf4pmMqJPJJJfLfbzd7/fCreVyqdm6l271crnE4/HVaqU9dLlcUPE02sM76Va73W4wGKx8TlUHgwHdZtKn7nY7SZLevoQLDLXT6dAPMOlTS6XScDikp9drOp2G2mg06IBJhzqdTrPZLD29VS6XoeJi0wHTs+rxeIxEItwtbTabUJPJJB0wPaXixuIf1Ov14leQzm7JsgzV5/PRAdMD9XA4hMNhh8OBvzO73S6K4nw+1y7U63W/368uOJ1OXO9MJqNd+LYHqklZqtlZqtlZqtm9A49eHwXIguU5AAAAAElFTkSuQmCC>

[image30]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACkAAAAlCAIAAABQwFfaAAAB/ElEQVR4Xu2WzcthURyAbxElWbLysfGdFBsxdjb2xIqNhY9kZ42Shc3YK2VFWPgH7ISUZGlDekMWdlKanPl1T29Nv5zXnKm509R9lue55zxdv9x7BfLvEPCChMht6ZHb0vNftX8weD6f+NJ38LVzuZzP51Or1YIg6HS6YDD4TSQUClmtVrfbXSqVTqcT3saAr01JJpPQ7na7aH0ymWg0Gr1efzgckHrJn7TNZjO0j8cjFoRks1lQmUwGi1dwt3e7HZzucDiwEKlUKmDD4TAWr+BudzodOB3uDwuRaDQKtlwuY/EK7nY6nYbTe70eFoRMp1OlUmkwGPb7PXav4G6zhr1arUwmk8ViWS6XSLHga9NhQ+Djk+12OxqNCoWCx+OpVqu32w3vYcPXpsOORCLff6FWq8VisXg8Ph6P8YYv4WvTYQ+HQywIaTaboIrFIhZs+Np02JfLBQtCHo8HPOnAzudz7BhwtOmwXS4XFp8YjUa4oNVqYcGAo02Hnc/nsRCBH0MQGQwG2DHgaNNh9/t9LEQajQb9C9zvd+wYcLTpsM/nMxaELBYLlUql1Wo3mw12bH63vV6vIWy329H69Xqt1+sQ9nq9s9kM2a95306lUn6/H16O0FYoFIFAgL6zAZvN5nQ6E4lEu92Gzwe88x3v238PuS09clt65Lb0/AQEErVT4CAEyQAAAABJRU5ErkJggg==>

[image31]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFwAAAApCAIAAAA3Ytl9AAAEQklEQVR4Xu2YWyi1WRzGN+VG5HBDEW0XGlEO7XIaQkIUqX3hVERy+lJyYZxK4YLIxMhEOZRTiBv2lYspEUnigkFS+hI2ETl/7O/pfRvt+b/r3WdMzfpd8X/Wai3PWu+z1qLQcSQoaIHDTWHCTWHATWHATWHATWHATWHATWFgA1NeX1/VavXOzg4VPpe3t7cfMtCmxrCBKb29vQqFYnZ2lgqfyP39fXx8fGBgoELA29s7Ojr6V4Hw8HClUqlSqbq6uh4eHmhPFtaaotVq3dzcMA9YQzVjYA3Hx8fz8vIiIiJ+YVFbW0v7GMPT0xOTOT4+JvX29nbUY2Njn5+fiSTFWlOKi4uDg4MxXkNDA9UMsr6+HhYWFhcX19raurCwgK/vbwlXV1e0m0GOjo4wE7hJBYGAgACoo6OjVJBglSlra2swpa6uDoMVFRVRWZ6xsTEvL6/JyUkqWMfQ0BBmUlpaSgUBLADUxsZGKkiw3BTka1JS0vn5eU9PDwZLTU2lLWQ4ODjw8PDY3d2lgtXk5+djJkyv8ak6OztD1Wg0VJNguSn9/f1ijszMzGCw0NBQ2kKGqKgo9KVVW+Dr64uZnJycUEGna2tr+/BMuby8TExMFE+75eVljIeEo41Y7O3t4WjA8UkFqzEQKBMTEw4ODnDk4uKCaiwsNKW8vBxeiD8fHh5iNvb29qbcCDC/rKwsWrUFYqBkZ2d//4etra3h4eH09PSYmJiRkRHaQR5LTNnY2CgsLHz/FXcEhQBz3xL6+vrKyspo1RaIgYKU/V2PmpqatLQ0nAbb29u0gzxmm4Kdn5KScnp6ql90cXHBhGCWfpHJ3Nwclo5WbQECxc7ODsFP6i8vLxkZGfh8mAHMxGxTsEtDQkJ++zeiKfPz87S1BEwal727uzsqWIcYKLjRUkFgdXUVKib59PRENRbmmXJ9fZ2cnPyXBBw9GHVgYIB2YFFQUFBRUUGr1iEGCpKOCgJi6gGkDNVYmGdKZWXl0tISrep0iDcM2dzcTAUWt7e3/v7+tn0riYEyNTVFBYHp6WmFcBScnZ1RjYUZpsBmjE2rAtXV1QYWSsrm5qaPj09JSQm2HtUsQryhkKR7ByEI1fRTz1RTcOfBu1PufOno6MComZmZVJAH+6Wqqsrd3T0hIQE/dHd3/yGBuSuliIGCpw0VBPA4hhoUFHRzc0M1GUwyBSugVqv9/PxwtaeaQEtLi0Lm4mQY3CYGBwfr6+u/sTDl8QZw9GJ07DtSh1k5OTniamEgohrAiCmPj4+RkZFOTk44MhwdHZVK5f7+vn6DpqYmLILYAI8LHEy5ubn6DT4OrVaLNx5GR1jgL3d1dX3/HwpeEvigVCoVnqmLi4u0pzGMmPL/hJvC4AtM6ezspOEhg4mZYnO+wBSNRvOnaaysrNDOn8IXmPLfh5vCgJvCgJvCgJvCgJvCgJvCgJvCgJvCgJvC4CcCBrhn9/n0+AAAAABJRU5ErkJggg==>

[image32]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFwAAAArCAIAAAB6qnh2AAAEq0lEQVR4Xu2YSyhtbRjHN0UM1HG/fQgDFBkYMPgYoFxGSiGkDCghchngIykD94mBy4AUJQMT6hO55JbLFlIoyuWgiNzv7PNvrc7X3s96195r7e0722D9Bqft+a+13nf91/M+7/MelUZBgIoGFBRTmCimMFBMYaCYwkAxhYFiCgPFFAZfY0p7e/vZ2RmNmsDExMTu7i6N/im+wJTx8XGVSjUyMkIFY7m5uXF2dpZlyuPjY3R09N8iJCUllZWVqdVqepsIppry+voaGBgIU7q7u6lmLLW1tVlZWTRqiPf394uLC1dXV0xmamrq7e3tnePp6Wl9fR2+WFhYlJeX09tYmGpKY2Oji4sL5lFXV0c1o7i6unJ0dNzb26OCBC4vL/Hm8IUKGs3z87ObmxvmibymmgCTTDk5OUlMTCwtLcVgeXl5VDaKioqKnJwcGpXG8PAwZpKWlkYFjtjYWKjV1dVUEGCSKZmZmZubmy0tLRgM+Ull+Zyfnzs4OBweHlJBGkVFRZhJR0cHFTj4TOnv76eCAONNmZ6exiTwY2BgAIOFh4fTK+RTUlJSUFBAo5IJDQ3FTHZ2dqig0YyOjkLy9PTE8qSaACNNQRmLiYm5vr7G78nJSYzn7e1NL5LJ6ekp0gT/UkEaegoKKhQKHx6+trZGNRZGmtLW1tbb28v/3t7ehinW1ta6l8gmPz8fmUKjkmEWlIODg6amJlTu7Oxs7E3akh6MMQV9WkJCwufnJ/8n8kXFgW+leyEF+RUSEvIXC3d3d0tLSw8PD+2gl5eXlM2Chy8omFjZb2AEFrW/v39nZ+fDwwO9QRxjTMFgJA9tbW0xoa2tLe0gExj3k0V6ejqqCQliKX18fNBHiMAXFOFeji0yODjY19cX3QqRxJBtytzcXFRU1L+68K2K9K9K2N/fR4YbTDQ98AUFdZQKHOi2Mb2AgID/sls/8kxBgxgXF1crwMfHB6P29fXRG6SB/hUPoVE58AUlIyODChzY4/kFztyYhMgzBQe/np4eGtVokpOTMWRDQwMVBKDpvtZleXnZycnp+PiYxMHt7S29XwS+oHR1dVGBY2xsjDdFuLiYyDAFnVV8fDwzAwsLCzFkcXExFXRBoUXZ+6GLlZWVjY0NCfLY29vjfehTWPAFRewMiX0NalhYGBVEkGEK+teVlRUa5aivr8eoqampVDAEGmJ0Fvf391SQA19QsH9RgWNmZgb7GiwWs0yIVFPQmKBQ0ehvsKxgSkREBBUMgcNBa2srjcpkaGhIJehQeLCg7OzssLuj/6aaOAZMeXl5QUMVFBTEr0kky9HRkfYFg4ODubm5/O6DD4JjYXNzs/YFelhdXUVjgipDBWmg4tTU1GAjx0MwOlZQVVXVPxyVlZUpKSl+fn5YrQjKalI0Bk0Bi4uLWDUbGxuoiLOzs+Qd0M7Oz8/j9XCBWq1eWFiQ2EoDNFpIMRqVDD4Ylsa0CEtLS3d3d/QeaRg25X8C9uG4hBejwjfAbKbgPPmF/1n3tZjHFKQ3Fjx2aCp8D8xjSmRkpNHt7x/APKZgh8KJgUa/DeYx5ZujmMJAMYWBYgoDxRQGiikMFFMYKKYwUExhoJjC4BcPtc8e/J3o8AAAAABJRU5ErkJggg==>

[image33]: <data:image/png;base64,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>

[image34]: <data:image/png;base64,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>

[image35]: <data:image/png;base64,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>

[image36]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAVIAAAApCAIAAADoJTYOAAAMT0lEQVR4Xu2bd1AUTxbHF3NEUEmKAUFBAUEF44kI5oCnAoKxFFERBDFnEcyhPPWsQtQy53RGjGiVEVEULeRELTOomAMigty3dsr9rW93Zmd3Z/l5bn/+gv727PS+7tfvvZ5ZWRGDwTAyZLSBwWD86TC3ZzCMDub2DIbRwdyewTA6mNszGEYHc3sGw+hgbs9gGB3M7RkMo0MCty8sLPT3979z5w4VipcfP34U8EC7MoqK5s2bt2XLFtpa7NCp+gkWFe1aLNBx/ASri3b9bUhMTIyOjqatgkjg9qtXr5bJZPv376dCMZKbm9u+fXtnZ2eZHFtb2zZt2vxDTosWLezs7Dw8PJYvX/7161d6pVGSlpZWsmTJyMhIKhQvCQkJzZs3r1q1KqYM4/H09OSmDLi4uNSvXz8gIODGjRv0MoMRFhbWtGnTsmXLYjympqatW7fmBoO1hMFgdUVFRWVnZ9PL/law8uvUqdO4cWMqCKKv2+fk5Jibm8NMcH6q/R1YW1tjME+ePCHtixcvRruXl1d+fj6RjJC2bdvCGnAqKoggMzNz1qxZHTt2dHV1dVIB7vro0SN6jSDx8fEYzLBhw0j7w4cPGzZsWKJEiWPHjhHJoAQFBWE8mzdvJu1JSUkVKlSwtLRUXV0CSG4uwowZMzBaCwsLKgiir9uHhoa6ubnhxrg91YodLBSMBNakghysIahbt26lgpEBCzRp0gSmQByjmiB5eXmzZ8+2srKKiIhYv359SkrKf1W4d+8evUwTQ4YMwWB27txJhaIiNEJycHCgAj+pqamDBg2irdqA4ImbZmVlUaGoaNSoUZCGDx9OBXUYyFzK3L9/v1WrVhiSiYmJVvFML7dPTk6G20+bNg03DgkJoXKxs2HDBowEc0MFOd7e3lBnzpxJBV2RtmSQ9tP4+Pjxo4+Pz5EjR2AKe3t7KvOD4WGzQCR88eIF1fRDwM3OnTsnk+f/3759oxoP/fr1Q//z589TQRzCkSMmJgYqciUqqGA4cynTt2/f9PR0+DxG9fTpUyrzo7vbFxYWdurU6dWrV6tWrcJdu3XrRnsUOwJxo6CgoHLlylClyhjfvn1bq1YtfH0q6ASGV7t2baw5KkjNuHHjTp06dfv2bZgCKSuV+cFmqpqH64+wmy1atAgq6n8q8ID0u2rVqriqT58+VBOHcOTo2rUr1EmTJlFBBQOZS5lDhw5xKXa1atUwqqtXr9Ie/Oju9gkJCVw9v3fvXtwVexvtUewIxA1uAUlY22NSJ06cSFv1YM2aNagAaaukIDL0798ff7x+/Vom58OHD7STOk6ePNmgQYPPnz9TQW8E3OzNmze2trYI3chNqMYDZiQ6OvrLly+odR88eEBlEQhEjosXL5YqVQpJu8Zq3HDmUoBson379vim+NvFxQVjPnjwIO3Ej45ujynp0KFDgfzZGMyBu1pbW9NOxYtA3NixY0fp0qXh81juVNOJbdu2YZuTNi3/8eNHjx49sD1RQTp69uypOI4qU6YMzIXy8tcu6gkODl67di1tlQI+N3v58qWvr2/FihWxLxCJD7gZ4h6XMU2dOjUqKor2EAFf5EhNTUU6VrduXZToRFLFcOZSMGfOHMWzM0QLjDk+Pv7XLkLo6PajR4+Gt3N/Y1vFXUuUKMHtAsLAoPdFg0/+/v07/QgeuLgBiz/7SVpa2saNG/38/FCMbdq0iV6gK4cPHzYzM0tKSqLD5QELhTbxcP369Ro1aiDs01tKwa5du+bPn6/4FxUKzHX27Nm/evDj6OgocoPQFs7NYCJuyhBIT5w4ERcX16hRo5EjR2p1Zo5i09/fn/v7+fPn2AJE5jIKuMgB31YsoczMzH379oWHh7u6usLTuOiqEcOZiwNW6tWrl+LfQYMGYdizZ8/+q4cmdHF7rE7luiU3N1cmR3WPJMCHPTw8HESDTOnMmTP0U3jg4gbSxX8pMXny5O7du4eGht66dYteoD0YP4xbvnx5e3t7OlYe0LNcuXJ2dnZU4AchDruqyBUmEkRCHx8f5YMxFMww1/bt25V68YLMFuGXtuqNws2Up2zx4sVYx0h8VqxYIX7TLywshOkUoQgMHDhw2bJlSl00w0UOpLHK44mNjcVuEhAQID6LNpC5FAQGBipvK5MmTcKwR4wYodRFA1q7PXLRLl26kPPJKlWq4MbYDpQbixnEDRMTE9UzNiwdbI1I8lUzSfHgQ5BTeXp6Dh06NCcnh8qSAoefNm0awh1WIbZUKusEtr/jx48rt8AmmDKRjuHm5oYsl7bqDedmERERVCgqunLlCvcCj8hKCj5JTv6wGrEkxGSgCrjIsXfvXioUFS1ZsgTSmDFjqKAOA5mLIzExccqUKcoty5cvx9hQwSk3CqO122Oq3N3dp/wK5/bij14kh4sbzs7OVJCDNQQVgxT/HEiZdevWIfd2cnK6cOEC1QxGenp6q1atUE0gt6Salty9e9fGxoZMGbJW2GTChAm0tzoiIyMR9Gir3nButmfPHirIQXSBunDhQiqoo127djt27CCNXl5eu3fvJo0CcBWHauQA+fn5pqamULGWqKaCgcwFsICRAmOjVJ5K5LMYGPJo2psf7dz+/fv3nTt3PqcC9/qHoY8xBODiBnJjKsjhTh8Aqn2qiQAJG6piJOpI9rR6Oqozb968QWFia2s7ffp0repbtfTu3fvo0aNkypC2wCADBgygvdWRkZFhaWmp29m4AJyb8eXDXMmKwVNBBYTWWrVqqVYEBw4cwNZJGvngIgeSLCr8hDsNQelBBRUMZC6AdYi6g0wlhoSB1axZk/bmRzu3xzam9kWI4OBg3DguLo4KKqBW/49oDh069O7dO/oR6uDiBt/Wjngikx868q0wMaB63LRpE+Ye5T3WEx0rP5gqrfqjuMVdkH5L8qwRtcncuXNpq/x5IWzi6+tLBR7i4+PhQhKeOGh0M+4XFuHh4VRQARsEjEZb5VNmb29/+fJlKqhDOHIgBZAHDt7chCC5uQBCjvJJngJkcxhYqVKlxP9eSAu3R6iEd9FWOePHjxcwmQLsx5ihf4oGO31ycjL9FHVwcYPvjSguXQwKCqKC9iD2YjorVapEx8oD5glj69atGxV4QJRAFnf79m16Y53Izc2FY+fl5VFB/jxC2OtUgQci5SFnBDrDuVlYWBgV5Fy6dMnExKRMmTIaE7SsrCxzc3O+8LBy5crAwEDaqg4ucuzatYsKchYsWCCTnz6KPGsoktpcoH///mp/5/rp0yduS1JbnqhFrNsj8rRp04bvrH7p0qUycfmYIeDiRsOGDakghzvwcHFx+fjxI9V0Ap/j6em5fv16KujNsWPH6tWrJ2EdMXbsWLUHVODatWswCxyGCoIgpXRycoKpsQThCf9WAVFOZIgTcLOcnBxEaagbRDy0Rx2k9lCQAy5RrVq1x48fU0EFgciB2IMNCHu9ts+DJDQX0kCBr4mxybSpYUW5PWyBshYrku9X0EgjZTyvyhQDqHZw95EjR5J2bAcwN7cfPXv2jKj68Pr1a2z84q0sBuQRNjY2Uj3v/fz5M9YZAibfK2UXLlzgQoTahS4AUjasZnw49pQIFaKiosTEHMRMfFncnfyOFe3Ioq2srJD1bNy4UVlSC9IZ9BT+QcsEObT1V27evInBODo6kva3b9/OmzcPPu/m5iayWCDob66CgoKDBw9WqVKFzyDYOLgzdfHPqjS4PfJDLqdFWKhQoQKSlszMTOUOMTExCKRch8qVK7u7u4s8JdIfxARvb2/cHUU7vrOZmZniN/atW7fG5u3h4RESEnL69Gl6pRRg9xX/rrgY/Pz81BaoOoBqy1wO5qV69eokomINNWvWDCoshuXi4ODg5eVl6KeSCpB8tWjRwsLCgtt0XF1dFb+xb9y4MRZY9+7dY2Nj379/T69Ux9q1a9WWu8og1CPg8wXVwYMHwxpY2zL5b35atmypGA+qLQTqfv36rVu3TqsHgRKCfAf7I2bK1NQUs4lqWlnFng73tLa2xjxiQtETLiDmVRcNbs8QAKtTqrd9saoQkVTPohnCpKSkZGRk0FYVUD3p9uz2T4W5PYNhdDC3Z2gmPT09MjKSFqbqQAWrsVj94/n9zcXcnqGZ7OzshISEeBGg2JbqheL/X35/czG3ZzCMDub2DIbRwdyewTA6mNszGEYHc3sGw+hgbs9gGB3M7RkMo4O5PYNhdDC3ZzCMDub2DIbR8T/8lH+HXp2ZBAAAAABJRU5ErkJggg==>

[image37]: <data:image/png;base64,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>

[image38]: <data:image/png;base64,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>

[image39]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAqCAIAAACGOGTnAAADuklEQVR4Xu2XXShzcRzHR6EooriQosSVdkeRZFwoSUoUZS5HSexCq3mN5ILatAuSUV6StyWklFASuRCikZewJCUvecnL7Pm25TxnP/acs+2cp0fP+VydfX+/s33Pb7////c/MtvPQUaFfxjJqzhIXsVB8ioO/4dXi8UyODjY3Nzc0tIyOzt7eXlJM4TGE69ra2tZWVk5OTkmk+n4+Hhra8tgMERERDQ1Nb29vdFs4XDP68vLS3l5OWzNzc2R0MnJCXSFQvHx8UFCQuGG19vb2/T0dBg6OjqiMTuorkwm6+rqogGB4Ov19fU1LS0tICBgfX2dxj55fHz08fEJDQ19f3+nMSHg67WiogI102g0NOBMVFQU0vb392lACHh53djYQMHCw8Pv7u5ozJmkpCR4nZiYoAEh4OUVK4ZPUUFcXBwyu7u7aUAIuL1igcvs7Ozs0Jgz6Gk/Pz9kTk1N0ZgQcHttb2/Hz0dHR9PAFxYWFhxPdX5+TmN2sOYWFxexXbS2to6Pjz8/P0O8vr7e3t6mqd/B7bW0tBQ/X1hYSANfqK6uRqZcLqcBO319fegQNBLs7u3tYY7k5eUtLy8nJibiIWn2d3B7zczMhIOGhgYacAYjIDY2FpljY2MkhC7ClyQnJ+OCrWOyxMfH+/v7Pz09sXVXcHvNz8+HA71eTwPODAwMIA37ANHhLzIyMjc399vxq9PpUlNTqeoCbq+NjY0wgTMKDbBAYbCz+vr64j9l61arFX8xRt3V1RVbZ5iZmdFqtVR1AbfX6elpeC0qKmKUkZGRmpoao9HIKPX19diAe3p6GMVBf38/7m1rayM6A1bhwcEBVV3A7RWNiOkaFBSE8wA+ohlwAsTF0tLS6OgoLoaGhlBRrG5yI8CNeIaLiwsa8AhurwAzMzg4uKCgAL7VajWjq1Sq2trasLAwNCsr/Te4CwuOqp7Cyys4OzvLzs7GWs7IyDg8PFxZWeno6ECxq6qqmLJhArNPLXiwwMBAzDxGIaCJsX9R1TV8vTrY3d0dHh6uq6vDZo5OwJRibzclJSU3NzesdFtKSkpMTAxbYYO/CBstVV3jnlc2Dw8PWDeTk5OOj1hGxcXFzim23t5e5JjNZqKD+fl5zj2b4K3XkJAQDDbUDzXe3NykSTabUqlMSEg4PT1lFIzWzs5ONLq7bxCee7V9nqoc/OFshdGPDQFVr6ysLCsrw1vQ6uoqTeKBV17xjoA3RMxPNDGNfQFVvL+/p6o7eOX1LyN5FQfJqzhIXsVB8ioOP8nrL9yIdx5psFpDAAAAAElFTkSuQmCC>

[image40]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAE8AAAAtCAIAAABgaqGAAAAFJ0lEQVR4Xu2YWSxdWxjHpYbihTZFCKkSMUUiMbwQhMbQIMVDiYc2EmK4EryghpcmQiTSCA+iSEkN1UhqaspFeUCQGkNTok3QEJrU0Jp77v+efe0s3znb3pvETU7P74n/t9ay/muv71tr0VH8SehQQaPRutVctG41F61bzUXrVnO5Vrc1NTUfPnygqkxOT08zMzO3t7dpQAKy3eKPraysDA0N/X3GyMjI169fT05OaNPzVFZWJiUlUVXJ0tLSlAS2tra49tPT0/7+/r9+/To/jDhS3R4eHjY3NwcFBRkYGOio486dOzDz+fNn2lNJf3+/h4fH/v4+DSjJzc19/PixoaEhxrG2tk5OTv5LSVpa2pMnT0JDQ42MjBCCznepra2Ni4tjxpCEJLfDw8Pu7u5Pnz7t6+t7+/Yt/rCTk9Pq6uri4iI+cnV1dXBwsK6uLnQTE5N3796R7gcHB3Z2djMzM0Qn+Pj4YATsdhpQKDY3NzFCYWEhK/r6+nZ0dLCKKOJu6+rqzMzMvnz5wv3a3t6OOcXExJxrpFwRc3NzhG7duvXz5082VFRUdP/+fVZRBV309fXRHYtIY0qePXv24sULVsG6Ywmw6VjxYkTcIqNu3rxZUVHBK+Xl5ZhTXl4e0+o/xsfHuV09MTHBi0dHR1gsrBHTUA29vb3o6ODgQANnVFVV9fT0sMrv37/RvqWlhRUvRsQtvlhnZyeroB5iWvX19azIw31e9vu0tbVhe6O2Ma3UgOVDR6EyBkpLSxcWFoiYnp4uumtYRNyqEh4ejmmNjY3RgEKBIqmnp+fs7MyKKD9SJsQlbWNjIyumpKTwP8/Pzx8fHzPBf3n9+jX+4u7uLtGFkO3WwsICxROFhwYUijdv3mDGmAErIrXUbnsWPmm/ffvGi/iSiYmJTCs1oD16vX//ngYEkOcW5ypG9/PzowGFAgtsY2ODY4MVUULQvqmpiRVV4ZL27t27q0pQ6pE+rq6ur169ok1VwNJjk1NVAHluURIwrfz8fKLv7e2FhYXBKrljYOpS1p5LWtiLjY199OhRZGQknENZW1ujTVWwsrJKTU2lqgDy3GZkZJDZ//jxAwcDMpNsYI6PHz+i/ejoKA2ch0tadgTsFJL/Qri5uWGBqCqAPLeOjo641nz//h2HML4AfrW3t4dboWsjt0Xn5uZogIFP2o2NDV7c2dlhS9QFYKUePnxIVQFkuMXZizlh6K6uLmzakpIS3JCFfHIMDg7qCBRwHm5FXFxcWBELyh7aF4BLXkJCAlUFkOH2+fPnmNbLly9pQBjcFtEFfmiAgUta6blHuHfvXk5ODlUFkOE2MDAQWw6rTgPCYEPCCZ4TNMCgmrSyMDU1LSsro6oAUt2iut64cUN6hvCguuI5QdUz+KRdX1+nMQlwNR+ZRQMCSHVbXFyMcUWvu6rEx8eHhIRQVflOxoscRyWGNTY2Xl5exuEsesEk4FqKb4BzgQYEkOoWVcTS0lL17iYKLoO3b98mxQwXepR0rEJERER0dDR+xnGNYywrK4ttJkp2dnZAQABVhZHkdnZ21svLa3JykgYkgDsm3F5iU4iCjYAS1dDQQAPCSHJ7RQoKCh48eEDVK4MVRFEQ+n+IWq7DLUqRra3tp0+faOBqBAUFtba2UvVCrsMt6O7u9vT0VPtyuhx43EdFRVFVjGtyq1A+x8kL6dJMTU15e3tLf9byXJ9bhfI2NjAwQFWZoDglJyfLuuTwXKvb/x2tW81F61Zz0brVXLRuNZc/y+0/w3YxmfBorZIAAAAASUVORK5CYII=>

[image41]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACgAAAAlCAIAAAC/AjzkAAABgUlEQVR4Xu2VPYrCQBiG09gIyuJPEnOCWGkpuJ5A26TwFBaCuUCqVBam8A42gqTJDdKEgBb2lpImTSDoDg6G4RtZ54tstslTvt+Eh5l3wkj3f0KCQVlU4tKoxKVRiX/HNM3BYPD1oNvtjkaj7wfj8Xg4HPZ6PTqyLAt+yYETU4hGkiTbtkF+u90Oh0Oj0VitVmDEgxZnWdZsNon4eDzC2YPlcrnZbGDKgRYHQUCssizDwRPXdff7PUw50GLHcYiYlA0HT9brdRiGMOVAi6fTKRGTbbEhe7ae5yVJwgxfgxPnBZ9Opzy8Xq/z+ZxZJQROTAtWFCVP4jg2DEPkNgFwYlpwu92m/26/36/VauAABMGJacHb7TZPoihSVZVZIgpCnBd8Pp/zME3TAgXfUWJasKZpbHi5XHa7HZsIghDTgovtjwch5gv+BFHxy4I/QVTs+z6x1ut1OCjKGzF56WazGXl3O51Oq9Uim9Z1fTKZLBYLuBTJG/HfUYlLoxKXRiUujR9moIoDx/z9bwAAAABJRU5ErkJggg==>

[image42]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACgAAAAlCAIAAAC/AjzkAAABgUlEQVR4Xu2VPYrCQBiG09gIyuJPEnOCWGkpuJ5A26TwFBaCuUCqVBam8A42gqTJDdKEgBb2lpImTSDoDg6G4RtZ54tstslTvt+Eh5l3wkj3f0KCQVlU4tKoxKVRiX/HNM3BYPD1oNvtjkaj7wfj8Xg4HPZ6PTqyLAt+yYETU4hGkiTbtkF+u90Oh0Oj0VitVmDEgxZnWdZsNon4eDzC2YPlcrnZbGDKgRYHQUCssizDwRPXdff7PUw50GLHcYiYlA0HT9brdRiGMOVAi6fTKRGTbbEhe7ae5yVJwgxfgxPnBZ9Opzy8Xq/z+ZxZJQROTAtWFCVP4jg2DEPkNgFwYlpwu92m/26/36/VauAABMGJacHb7TZPoihSVZVZIgpCnBd8Pp/zME3TAgXfUWJasKZpbHi5XHa7HZsIghDTgovtjwch5gv+BFHxy4I/QVTs+z6x1ut1OCjKGzF56WazGXl3O51Oq9Uim9Z1fTKZLBYLuBTJG/HfUYlLoxKXRiUujR9moIoDx/z9bwAAAABJRU5ErkJggg==>

[image43]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACMAAAAfCAIAAADiA+PYAAABk0lEQVR4Xu2TMYrCUBCGY2GhHsEqGLCwsLTyAEELD6CNiKbUOlhqI8EjBCRa2AgpcgJRLGztFGIwYCxUVEQMcYcVsrNZs3mQ3WWLfNXwT977yGRCPf4Kyhn8GoHJD4HJD//MtN/vZ7PZ9Xq1k+12O5lMNpsNesoDb9NqtSoWi61Wi6ZpXdeXy2WtVuN5XpKkTCbTaDScB1zwNlWr1cPhYJpmKBQqlUrlcvl4PD5bw+GQoqj5fP75xGs8TJfLpVKpQKGqKlyaTCbP57PdVRQFQvB9HHDHw7RYLGRZhqLf78Olg8EAdwVBgHA6neLQDQ+TDbwZTM8wDByyLBuLxW63Gw7dIDUxDJNOp3FyOp0ikUihUMDhNxCZNE2DKdXrdRzCJO15WpaFWy8hMvV6Pbh0NBrhMJfLweieC9JsNtfrNe5+hcgEmw0fabfb2Qn8xeFwOJ/PP973k2SGRKZEIpFKpXByv9+j0Wi73Ya60+mMx2PcfQmRKR6Pd7tdRyiKYjab5TjOsfpuEJl+hMDkh8Dkh8DkhzfrgieIz0PE9AAAAABJRU5ErkJggg==>

[image44]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAC4AAAAlCAIAAACyHEyjAAACWElEQVR4Xu2VT4hpURzHb4QkG1tlZysLFrKwULKYprFQataSDTZsLEiKSakZrylJGTULyWoakj9lYWEhexskJBJJQzIzv+bW6XbefS7u9N68up/VOd/zu/f36d57ziU+fgwEHvw7OBU6OBU6OBU6/luV7Xa73+/x9Iv39/fRaISm0+l0MplQ1pk5VeX5+fnq6spsNisUCpVKFY/HqU673c7lcnm9XqPROJ/PfT5fMpm8u7vTaDTL5ZJym2OcpAI9IpEI6v3w8MDj8bRa7dvbG5lkMplGo9FsNgmCsFgs6/WazCUSST6fJ8eMMKtAA4fDgYW3t7fQ1ePxkNOnpyd4QYlEQigU9no9MhwOh1BTr9fRVcdhVnG73Wq1+vX1lRpWq1VoI5PJqKHNZoM3iKa5XI7P569WK0rJMZhVrq+voavBYKCG/X6f+AIGKJTL5bFYDE2tVqvJZILBiTbMKuVyGTywp9LpdEgV1Kbb7cK01WqRU8hFIhF87DC22+3owiMwq9Dy+PgIjWEroQS2jFQqRZ/2YrEQi8WDwSCbzZZKJVR2hEtUDocDSIBKpVJBITw82EeUqo9isRgKhag1x7lEJRqNgkcwGMQX2HG2SrvdFggEcNLgC6w5T2U2mymVynA4jC98B2eobDYbvV6fTqfxhW/iVBXYGnCiFwoFagjH63g8piZsOFXF6XS+vLxgIRxisJuw8GJOUvH7/Tc3N78o3N/fBwIBnU6Hl7KAWSWVSpEH6+/ATxGvZgGzCvx1g3+gVqvh1SxgVvlrcCp0cCp0cCp0cCp0/CCVTzsT8Popq1S2AAAAAElFTkSuQmCC>

[image45]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAfCAIAAAAJNFjbAAABRElEQVR4Xu2SMYqDQBhGTSGI9oJXCURIKvECBgKCpNILmAMIaUWxsQixCUIq8QTaeALtxcJSbBKxcHdYIbizyozLLuyCrxj8v/mYJ47E2y9DwMFPswiQLAIkf09QVVWSJEVRwBsTzBCkaSqKomEYvu+DVVXVtm3h0hdwBWVZchyX53k/Pp9PWZZvt9vn1gi4gtPpxPP8awRHEwQRx/GgMg6uQJIkmqbBx3k8HmBsmibLMrg0Bq7A8zziA4qittttEARwYwJcAeB+vwuCQJJkb7pcLnBjjBmCnrqur9crwzCbzQbeGwMtiKKIZVnbtofh4XDY7XbDZAq0QFGU1WoVhuEwXK/X4FaGyRRogeM4pmm+xq7rzufzfr8HD4PWJGgBwLIsTdN0XT8ej+B/dV0XbkyDJejBfGWIGYLvsQiQLAIk/1/wDjXpM9RMV3HoAAAAAElFTkSuQmCC>

[image46]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACgAAAAlCAIAAAC/AjzkAAAB/0lEQVR4Xu2VTasBURjHh4XwAeQDWPoMUhKxYiHZiLBQXlIWLC0U2Up2Ikt2Ft5WsmJPKRtWSnlJecu9T5TGMzP3zFy3ud3u/Hbz/M/MrzPnnOdQH78EhQtiIYlFQxKLxh8Ub7fbZrNZKBTS6XSlUlksFs+o1WrRBrLzHfF0OnW5XBqNJhAIVKvVfr9fLpftdnsul4O0WCxaLBb8DgNh4uv1mkqllEplJBLZ7Xb06Ha7xWIxt9stl8uz2Sw9YkWAGEw2m02hUDQaDZzdORwOWq2WoqjhcIgzBnzFl8vFbDbDR+Hf4oxGKBRSq9Xn8xkHDPiKo9EoWGEhcfAKLLPJZMJVNniJx+OxTCaDpV0ulzh7pVQqZTIZXGWDl9hoNMJ0PR4PDhiMRqPZbIarbJDF8/mcutPtdnH2BmQxtAiwwpaBs4SzNyCLoUuA2GAw4OA9yGKr1QpiOCc4YLDZbHCJG7LY4XCAOJlM4oCB1+s9nU64ygFZDD0SxE6nEwevwB5MJBK4yg1Z/DjEOp0OBzSgUcNhW6/XOOCGLAbC4TBM+ovLDuY6GAxw9Ut4iff7vV6vh3twMpmgCHqZ3+/vdDqoToSXGDgej3Dhq1SqYDBYr9d7vR7cuz6fLx6PC9rMT/iKH6xWq3a7nc/noSHXajV4xCN4I0z8g0hi0ZDEovH/xJ+CoJUQjmgiuQAAAABJRU5ErkJggg==>

[image47]: <data:image/png;base64,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>

[image48]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACEAAAAkCAIAAACIS8SLAAABwklEQVR4Xu2Uu+uBURjHX5fNoCw2iswSmZgli5UoSZRJLmVR/gZlsriUsmKyWQwUo0mRQZLbSC6/p5Se9+I9z69+6je8n+mc73ne8+l5O+dwz+/DCYMvoDjoKA46/8ZxPp9ns9n9fn9Nb7fbdDpdLpf8qo+wHZvNJhQKVSoVk8m0WCwmk0kkEqnX69ls1ufzHQ4H4Qci2A7YCzQw0Ol0Xq+3XC6/G3K73YlEglctBcNxvV6j0SgM9vs9x3EejwevxmIxrVZ7uVxwKIbhgJ/ebrdh0O/3wdFsNvFqMBiEcD6f41AMw/Emn8/DdqvVCoc2m00ciqE6XC6XxWLByW63A4HBYIBjhnMxJMfpdNJoNPF4HIetVgscqVQKh5KQHL1eD7ZrNBo4DAQCer1+u93iUBKSI5fLgWMwGLyT0WikUqmq1Sqq+gjJ4XQ6jUZjMpl8TeGwWa1WuJX8qo+wHcfjUa1Ww1WAPsLhcDqd9vv9uCcmbEe328U34/F48NfZsB3wllAugQxsh8PhMJvNwvQ3yDnW63Wn04Em7Hb7eDymPLGSyDlqtVqhUCiVSsViMZPJDIdDYQUNOcdfoTjoKA46ioPODyE1Pl5u5hB7AAAAAElFTkSuQmCC>

[image49]: <data:image/png;base64,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>

[image50]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAfCAIAAAAJNFjbAAABXElEQVR4Xu2TsaqCUBiAHXRwqKktKNAXCJ16AScRtxYHl3DQF3DSVueGHkCoyRfQWYSGJheFIFpay0kR7/3hQpyOxbHLvXAv+G1+/vh5PEfq45ehcPHT9AEifYDI3wtcLpc4js/nM37jBW8EsiyTJMkwjN1uZ9v2fD5P0xQfatE1sN1uR6NRFEV3s1qtJpNJURTI1BM6BcIwpChqs9mgcr/fg1yv16hsQw7cbrfpdMrzfF3XqD8cDhBYLpeobEMOuK4LD3IcB/OwE+B1Xcc8Bjkwm83gQUmSYN40TfCe52EegxwYDoc0TZdlicqqqmDPGYY5Ho+ob0MOcBw3Ho8xGQQBvD4cJMy3IQc0TWNZtmmau4HViKIoCAKsAxl8DjlwOp0GgwH8B1+XcKgURVksFtfr9XHwOeQAkOe5qqqWZcHGyrLs+z4+8ZpOgTvoh+rIe4Fv0AeI9AEi/z/wCQoeIoKwFNBAAAAAAElFTkSuQmCC>

[image51]: <data:image/png;base64,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>

[image52]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADEAAAAqCAIAAACV7yQTAAADOklEQVR4Xu2XXyh7YRjHR2lKEcXVRMmtS8XF8udCkxuJooY7rVyYC+3CmEgUiVyQQg1pQtLalYVcWIq0uVC2YZI7fzIMOb45Wec8zHlf61f6dT5X757vc3q+vec57/NOI/w9NDTwB1A9saF6YkP1xMb/5eni4mJubq63t7evr8/pdF5dXdGM3/IbT7u7uxUVFVVVVaurq4FA4PDwcHx8PCsrq6en5+XlhWbzw+cpEomYTCaUd7lcRAoGg4iXlpa+vb0RiRcOTzc3NyUlJSjs9/up9gF2S6PRTExMUIETVk/Pz896vV6r1Xo8Hqp9Eg6HExIS0tPTX19fqcYDq6fW1lbsgcVioYIcnU6HtOPjYyrwwORpb28PG5CZmXl7e0s1OYWFhfC0vLxMBR6YPKFzWTYJ5OfnI3NycpIKPCh7wgel+cDr9VJNDnouKSkJmWtra1TjQdnT0NAQyuTk5FDhCxsbG6L7UChENR6UPTU1NaFMXV0dFb5gNpuRWVBQQAVBuLu7o6HYKHsqLy9Hpe7ubirIwVGZl5eHzKWlJSKNjIx8azQWyp5qampQaXR0lApy7HY70vDdUUEQcNI2NjbSaGyUPdlsNhTDrKWChIeHB5xMiYmJW1tbRHp8fExOTp6enibxH1D2tL6+Dk/19fXRyOLiYkdHh7RMV1cXDrCpqaloBLjd7ubmZoPBgMerq6ux9vl80oRYKHtCo2CqpKSkYN7hJ14ibiZYbG5uOhwOLObn57FDGHbkQRE0YnZ2No3+iLIngFmRmppaW1sLf+3t7dF4S0tLZ2dnRkYGmkmSLoO3mQRGT+D8/LyysrKoqKisrOzk5GRnZ2d4eBib19bWdnl5KeZg8pDp+/T0hGaamZmRBhVh9SRydHS0sLBgtVr7+/vxBnFqo7ujqtFovL6+lqQL29vbaKbT01NpUBE+T1Lu7+9Rb2VlRfw5Ozvb0NAgTxFwLc7NzRXXg4ODZ2dncv174vWUlpaGg764uBh7dnBwQHLwZnFLxmJ/fx+fKlFj8XtPwuctQOTbuwDeGo6AgYGBsbEx9jtxXJ5w58Q/BQwfNBnV4iAuT/8I1RMbqic2VE9sqJ7Y+Iue3gFbF7eKzaBtRQAAAABJRU5ErkJggg==>

[image53]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB0AAAAkCAIAAAD6hKY9AAABRklEQVR4Xu2Uv4qDQBCH9Q3yEBLExqdInzZNCtHGxpcwQl4gXYo0acQ/pWBh4SuIhY02GiIYUmmRIjfcwoGDy67hDq7wq2bnN3zIsK7w/hsE3PglFi9h8RL+hzdJkmEYcHeKGV7P8wRBiKIIB1PM8Oq6Dt62bXEwxQzver1WFAV3KfB6b7cbfKxpmjigwPAWRXE4HGzb3u/34N1ut1A7jvN4PPDoGIb3fr9H32w2G1EUwzCEOo7j1+uFR8cwvD/IsqyqKu7S4fI2TQNLsCwLB3S4vNfrFbxBEOCADpfXMAxYbtd1OKDD5ZUkadZy3zzeuq7Rcnl+ZbbXdV3w+r5Pjmmawv0dj0zA9p7PZ/DmeQ513/e73Y7nSWN74ZKtVqvL5ZJlmaZpVVXhiSnYXqAsy+PxeDqdns8nzihweT9g8RIWL2HxEr4AQurOJHL8iDcAAAAASUVORK5CYII=>

[image54]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEoAAAArCAIAAABQGonZAAADw0lEQVR4Xu2YSyg1YRjHhxKliGJFlGz12SgWclmc6CQShdxWKAoLWbidSBSJLEgu5ZJcQ2LjmgURCQvlTrIgl9zJfP/PfE4zj+OcOTi9RvNbvef5P/PO+5/3fed95nD8r4ajgd+Fak/JqPaUjGpPyaj2PuDo6Kijo6O0tLSsrGx0dPTk5IRm/AA+Y29+fl6j0Wi12sHBwZ2dndXV1fr6eldXV51O9/T0RLOZYp69h4eHjIwMOBkbGyPS7u4u4sHBwS8vL0RiiBn2Li4ugoKC4GF7e5tqr2AOOY5raGigAjvk2nt8fAwMDLS1tV1YWKDaGzc3N1ZWVk5OTs/Pz1RjhFx7mZmZmJn8/HwqSHFzc0Pa5uYmFRghy97i4iKmxcXF5fLykmpS/Pz8YK+/v58KjJBlDy8MOVMHvL29kdnY2EgFRpi2h1ci98ra2hrVpGB/2tjYIHNoaIhqjDBtr6qqCiP28PCgwjsmJiaEB3F4eEg1Rpi2l5ycjBHHxsZS4R05OTnI9PHxoQLPX11d0ZCZnJ2dpaenT01NUcEopu2FhoZi0MXFxVSQgtPcy8sLmb29vUSqqakx6FkPyrrx8XEafaO5uTkhISErKwudd3d3U9kopu1FR0ej39raWipIaW9vRxrenFTgeRQDSUlJNCoCL62+vj4alXJ6emoReyUlJegXpTMVRNze3uLEs7a2npmZIdLd3Z2dnV1LSwuJi2Fpb2RkBP3GxcXpI7hHXl6eeMRFRUU4GJuamvQRMDk5mZKSEhYWhsujoqLQXl9fFyfoYWkPmwrlmL29PWpO/MQqxecPGtPT0z09PWh0dnZi3lBwkgsFsGnd3d1pVApLewBFloODQ0xMDKzm5ubq42lpaQUFBc7Ozth4onQJBjfetRT0iR7EEax2cokF7YGDg4Pw8HB/f/+QkJCtra25ubnq6mpMaXZ29vHxsZCDko0U0/f399h4ra2t4uDAwMAfKfgK8fT0FEd8fX1xF/FVlrUnsLGx0dXVVVhYWF5ejiWKGkX8mBMTE8/Pz0Xp/OzsLMa0t7cnDr6H8eI0CJYQ7oepEH62tbXFx8dLU/4daJgWoV1ZWbm/vy/V//Nz7Tk6OqKsCQgIwEyurKyQHCxdjUaDxvLyMl62RNUjxx4WDifj+CV83h7/9n0gYPArAcsS50FFRUVdXZ2RPymM2xseHk5NTY2MjIyIiNBqtXiaWAg06QO+ZA9f7rgfqjZsSKqZg3F7X+FL9r4LnApLS0s0+h38CHuWQ7WnZFR7Ska1p2RUe0rml9v7C9OGWuC5yYYdAAAAAElFTkSuQmCC>

[image55]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARQAAAAtCAIAAADgEAP/AAAMRElEQVR4Xu2cd0wU2xfHAQsajcZObKCCxm4sBAsKliAGzM+G2Ds2sEsUEFxFRcUOCMGW2EDBroiKYBdrRLGCvYNYEAVE9vd9e8Nk9izsLrvLLrx3P3+8zNxzZzhz7/mee+7s+IykHA5HI4xoA4fDUQ8uHg5HQ7h4OBwN4eLhcDSEi4fD0RAuHg5HQ7h4OBwN4eLhcDREc/G8fft2z549y5cv9/f3P3ny5MePH2kPTukjMzPz8OHDa9eu9fHxiYyMfPLkCe1ROigTfmoinuvXrzs4ODg5OeHxnj9/fu/evaCgoLp160okkj9//tDenNIBkt2ECRO6desWHh6enJycmpqKoGzdurWLi0t6ejrtbTjKip/S4oonJydn+vTp0ElMTAwxvXjxAu329vb5+fnExDE4W7durVGjRkBAAJmdrKwsOzs7MzOzDx8+iNsNRVnxk1EM8Xz79g0PAIUgGVCbDKw/RkZGoaGh1MAxHIjCefPmmZiYHDlyhNpkJCUlwerq6koNxeT06dOTJ09G9rSysrK1tcXqERUV9ffvX9qvCPTmpw5RVzy5ubk9e/Y0NTVNTEyktgKQHoyNjZE58vLyqI1jIBYtWoSMtmnTJmoQYW1tjT63b9+mBvVASLRt2xY3CQkJuXTpUkpKytWrV7dv396rVy9LS8szZ87QCwpDD37qHHXF4+7uDr/xhNQgT8OGDdGtdG7v/oMcPHgQ02FjY0MN8owePRrdwsLCqEEN7t69i2qqqOUiPj6+Xr16CQkJ1CCPHvwsCdQSz82bN7Gk1KlT5/v379QmD8sN0dHR1MDROz9//kRYYzquXbtGbfJ4enqim4eHBzWoAlVZkyZNTp48SQ0ibty4gcj59esXNRSgBz9LCLXEg0JWnWUHoN4tVbnhv4xEIlEnnYMpU6ag54gRI6hBFSjP2rdvT1sV6Nev3/Hjx2lrAXrws4RQLZ4XL14Yybh//z61yYN9UYUKFdDz6NGj1MZRxdevX1OKAxI2vYU8FhYWmIstW7ZQgwLYnKDn3LlzqUEVERERLi4utFUBrBVBQUG0tQA9+FlCqBZPYGAgPDY3N6cGBeLi4pjM3rx5Q206BdUCdo2xsbEouKmtNJGfn3/nzh3smPFfalPAzc3NsjgEBATQW4i4desWmwvkPmqTJysrq1KlSui5Z88ealMFLsE+hLYqsGDBgo0bN9JWGfrxs4RQLZ5x48bBY3USDFICerZr144adE12dra3t7epqemcOXOorTSBpdjHxwdT7u7uTm0lzM6dOzEXdevWpQYFUCagJ0qGT58+EdOPHz9IC0F78ejHT5Xk5OTAw7Vr11KDUlSLp0+fPnDaz8+PGuRBlm3WrBl6Hjx4kNpKhq5du5Zy8TBsbW31L57ly5djLlDnUIMCEydORM+ZM2eS9g0bNqjMg9qLR3s/saobGxtnZGSQdoHLly8vXryYthZw7dq14cOHz5o1y8zMbNq0adSsFNXiGTJkiJGqF/Bg9+7d6GZtbU0NJYadnV2ZEE/fvn31Lx5sITAdgwYNogZ5UlNTK1asWLVqVcVPEzG8Y8eOJY0E7cWjvZ9Lly5t1KgRaRRz+vRpdca/TZs2uhcPnMPjIUNQg4hfv341bNjQxMTkwoUL1KYj8mWIW9QUj64+F8J9MjMzFRtJiyJqiufevXtHikNR33kwEhISMGuoGqhBHpYZFSf39+/fqDZ37NhB2gnai0dLP6WytwjKRW5I8Rw/ftxI/v1gRESEp6eneGR9fX2xdIaHhwstUtleEA9mYWGxf/9+1oL1sXnz5kOHDhU69OzZs3HjxlhYg4KCMDRYlDEZZAmOiooaNmwYFlZIBVbhpR8Tz7FjxyQSiZeX14ABAxB/wlVIUTNmzFiyZAkKTmdn58OHDwsmbD3RGUXmmjVrTpw4geygeDmIjo7Gfg8TP2rUKCTIZcuWOTg4HDhwAKa8vLzVq1dPnz4d94dL5MFRCaDGkMgIDg6Gn+pMnr+///+KA3YL9BYiMIbYHtSvX1+Qd2JiImZt1apVeHzWcv78ecwsIk+cAtA4fvx4R0dHtiDg+MGDB4KVoL14NPaTfT+KqcHlKODhZ1G/LhpSPPAYIV6lSpVv377hFPUb+1EMOYNF0t69e7HmFPouMi0tDY+9a9cuocXe3h6ZWDh99+4dU6bwsqV9+/YLFy4UOmAQW7ZsKcgJVbibmxs7RlB26NDh1KlT7HT27NldunRhxwBlbq1atdhwv3z50tTU9Ij8r+CQMe6AkWWn5HI8Y506ddj8PX36FJcnJyc/f/6clQ2IGOENSm5ubseOHTEI7BRCsrKywtSyUyQIXKvO5OkcCBtje+7cOansQ3jkCIwGZgQHaIEkatasiXRW6LdUyDjKayGG9uKRaudnfHw8rsW8UIMIQ4oHPHnypFq1akj/+bKv94T2qVOn+vj44Nmw4RF1l4OIB2MtFo9U1kG8n3N1de3fvz87fvXqFSpdcYq9efPm69ev2TFCHylHMIWGhqLSEE7hs9graJLUeMovnzRpktjPBg0aBAYGsuNLly7B5ytXrghWJJQePXpIZbkANwkJCRFMANJSZ/J0TnZ2Np7a0tLy69evCF8hbcOZyMhIZBY0FvVPSNTZ8Eh1JB5t/ITAULmQRmwifopA0YGEK24BivV2SYkHIGRR2CDaevfunZKSgkJr3bp1WI4Qke/fv2d9vn//rpge1BGPuAIUd8DcwIrkLVjFkAnetm1b+fLlRXbpw4cPUQqi3kNuwxBPnjxZbFV+ORZS1HVsiPFckERcXBwzrVy5El6hygosAIPAFiIUtDBhjRLuAzp37mwQ8UhlYTR//nxzc3Nra2sMI+pSPCYWRicnJ+GnJzwjqykEEM14XuVlIQPr7ZgxY2irAoh+5S+cNPNTKitkUFqLW1BlIFt1ENG0adPatWuLWwArmsSUoHgYCIt9+/YhFhFAKGxQboq/WcI4InmIuv8DEQ+KVEXxFKUubJZgvXr1qmAVg+hHpSuckuiHbMzMzLCss1MbGxtF8Si5PDMzE0OMagErEqYQmUIwrV+/Hl4pTiTA4MBEfro1oHgYqCGxM4Takach706dOom/dA4LC8PGT9RdevHiRTwFolDcWChv3rwRRlgJ2Mao861wcf3MycmpXLmyOHgKxcBlW6Fg7cMQHzp0iJ3iGUaOHCnf5R8QkeKFBdsn9cWD0cSGgaz4Z8+eZQdKoh/1nrGxsTh3YuME8Xz+/FloVHI5wFYKaRV7nmfPnmGShHZw//79cuXKkR0U2wcimFBnCvsfBoJAncnTGxAzVmN2jLyOHEGKIoSvhYUFO169ejUGU2zVGyr9RPkjiBzHwnspQukVT/Xq1bFuduvWDatQoR/LIHS8vb3ZMdYQlLatWrUSrBkZGbgJcrnQ4ujoiGVXOA0ODsbGXchbyExsHymVvTwYOHCg0BPTDMGw776/fPkCfzZv3sxMN27cgBvOzs4oCYQ3Y0oul8peHGO5RxitWbMG90EBKVSnYMWKFbhcaImJiUELO0Z90rZtW+ENBzIo5DR48GB2WhpAUOJJhw4disdHvsAIkw6oQh0cHKSykPX09CRWvaHST+Qvtk3FrGGrnJubSzow1BEPthuoU1T+3ETQXDzSgm+oGUV9SY0NEko1iUSC8MIK4+XlxWpZPCrmBosVYhqxxb4LhPSdZWBNENJMQkICdhQzZsyYPXs2G0HUiujAerKfnLE64clxir/F3mWfP38eZSRSF9QSHR2N/ARZYuP448cPdS5PSkpq0aJFnz59+vfvj5IPPpuYmKxatargsaSoKLBIwiuE2vbt24V2ZpowYYKPj4+fnx/Eg7+LdW/q1KniPgaEfZvMKPQLZYwVxicgIABZQ3FjrTdU+omKwMPDw9fXFzmu0CqaoVw8T58+xWQNGzYMs4+wRADglHYqAq3Eg1oWfw8Rhlqf2soyqamp2GKSfy5/+/Zt5D/FX7jLHGlpaWPHju3evfuyZcuys7OpudSgKz+Vi0cbtBLPv5VHjx7Vr19f+JGOkZ6eXqNGjdL2P3DhqOTBgwfkV2xdwcVTONj0o2BDMRkfHx8XF7du3bp+/foJP8hyOFIuHiWg3Mf+JyYmJjY29vHjx9TM+c/DxcPhaAgXD4ejIVw8HI6GcPFwOBrCxcPhaAgXD4ejIVw8HI6GcPFwOBrCxcPhaAgXD4ejIf8Hidczg5q9hU0AAAAASUVORK5CYII=>

[image56]: <data:image/png;base64,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>

[image57]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPwAAAAtCAIAAAAFq5G6AAALLElEQVR4Xu2be1BNWxzHU4yYkPIo5dm4MUkpeTQRDTKZTDJGmpKiRpNERIi8Skp5zhCJJmOqkcd451EeQ6JGU3mU5JFUKJSQq3O/c9bcfXfr1Dn75JyT66zPH+ac9Vtnt/Zvf9fvsfemIWIw1AwNeoDB+NNhomeoHUz0DLWDiZ6hdjDRM9QOJnqG2sFEz1A7mOgZagcTPUPtYKJXd3Jzc4ODg+nRP5o2ir6hoSElJcXX19fHx2fu3LkhISHp6elNTU30PIaigZMzMzODgoIWLFjg7u7u7+8fHx9fV1dHzxPMu3fvdHV16+vraYP8KHxtSkJu0Tc2NkZHR5uYmODfmpoaMlhYWDhmzBgHB4cXL140n85QJGfOnDE1NQ0MDCwpKSEjVVVV3t7eQ4YMuXHjRvO5cuDs7JycnEyPyomS1qYM5BM9NG1ubm5nZ1deXk6ZsBksLCyMjY1/w539B/D161dkVCMjo9u3b9M2kQgxVUtL68GDB7RBGKmpqdOmTaNHBaPUtSkDOUSfn59vaGiIiP7lyxfaJubChQsaGhrLly+nDYxfo7a21tbWVl9f/+nTp7RNTHV1tY6OjrW19c+fP2mbAKBaPT29iooK2iAAZa9NGQgVfWVlJaK4gYEBchZt+5cfP350FAMn0jZGW4FWHB0dO3TokJWVRdt4TJo0CRHnypUrtEEYCxcujI2NpUdloZq1KRyhore3t8e6ExISaENzhg4diml5eXm0gdFWNmzYAJd6eHjQhub4+vpiWlxcHG0QBhpQS0tLelQWqlmbwhEk+pSUFCzazMxMZoaysbHBzKSkJNrAaBNoorS1tTt16vTq1Sva1pyQkBB4Ho0jbRBGU1NT//79CwoKaEPrqGxtCkeQ6En8FrJT4TjMPHLkCG1gtIlFixbBnzNnzqQNEnh6emKml5cXbRBMaGjo6tWr6dHWUeXaFIts0efk5GDFmpqaMhudjx8/orzD5MuXL9M29aC4uDhBHi5dukQfgsf37991dXXhz9TUVNomwahRozBzzZo1tEEwRUVFaNtkJnOCitemWGSLPiwsDCs2NzenDRKkpaVhJhpZqJ+2/W9Bd44Ut3btWiFXNyMjY5E8RERE0IfgcfXqVQ0x79+/p23NqaysJOHm/PnztE0erKysrl+/To+2hOrXJgXsQHpIKrJF7+bmhhWju6cNEsyfPx8zp0+fThv+zyDy4QL36tVryZIltE3JHDhwAP40MTGhDRIkJiZipp6eHnU3GZX6uXPnhD8px/YWWHmrYG3fvn178+YNPcqjvr4+OzvbxcVF3ksjW/TkfpP0mARwSvr6+tjTv9VjCEXh4OAgr2d/nY0bN8LzU6dOpQ0SINBotNR0IbjiitTW1lLjrfH27duePXs2NDTQBglUsDYUyUuXLqVH/+Xu3bsIxEePHsXGW7x4MW2WimzRk/i9Z88e2tCc8PBwTENaoA1/BFOmTFG96EmMdHV1pQ3NyczMxLSBAwciNFKmZcuWjRw5khqUDjSakpJCj0qggrWh4RHi8xEjRihe9DExMVj3+vXraQOP8vLyrl27IoU9f/6cG0Tmwj5+9uwZymJ8lUxVpaWl9+7d42c9FGcoAV++fCkSZ7eSkhJ+uVZTU/P69esWE+Lnz5+x9ckP5aKurg4/bO2VIRyQ9CcCRZ+VlbVMHnbu3Ekfgsf9+/fh+QkTJtAGHqi+0CYiZJ48eZI//rcYCwuLgIAAfOCbpHPs2LEZM2bQoxKoYG3tKXqcHtbNJTIUUujqVq1atW7dOvLkFSrEju/Rowdm8n8IBYwdOxauQU0cEhJiZ2eH1o2YoLOJEycePHgwPT3dyclpx44dZBwNPmokFFSo9rZu3Xr8+HFHR8fAwECk3cjISHwNDQ21tLTkN0+fPn3y9/fH+MWLF1FoOjs737lzRyR+J8LW1hZbEc4tLi4mk01NTbt160bunWFTrVy50t3dHWk0KioK16+srIxMwy7dvn07rj2y5+7du4ODg/FHhVyAgoKCXfKA06cPwQPu7d27d/fu3bkn3Mi3WDOciVBCRnAQXJ34+Pj/fiaOQb6+vnPmzIHzcRZwOyU7KSAG6erqSnnuTlDB2tpT9MDPz09LS+vJkyci8d1c8jACQRfnid0Mzeno6BCpUSBU49xwYtgYycnJJLAhfEJ53F0CeNnIyOjmzZvkKxRmYGDAqeHatWs4AnRPvgL4GorkvmJXbNu2jftaUVGB7ffo0SOR+MLgyFgwZ01KSsLGIJ9RL9rb23N5A+JG4U4+w4nYk1wQQr5CEhNyARQO9jlO/9ChQ+QzuQGCNZOTQlTW1NRsrfI8deoUNCfz7ooknp6erR2Tj7LX1s6iR4ofPXq0ubk5Ii7/PxwgrEIcCOePHz/mTf8P1CrwC/XaKtQG4fKrFLQN3Gtq6JAQnjnBkW2TlpbGTba2tuZ8Ab/Aiu3HWUXiqnTWrFnkc3R0NDoz7mVx/CFSa8HdcPq+ffu4X6Eww6FwpoWFhfhAhR+cvpALoAwQFxFTsrOz+Z738fFBrOnXrx9SIm9uM1A+IcvRowLIyMiwsbGhR1tCgWtD4kVyPsdj06ZNSAX8ESD5sEhZoheJ6zAI6C8xCQkJqD1cXFy6dOly+vRpTr6QC/VeMRH9rVu3+IPYJwMGDNjBA0LH1idWfB40aBA3GbkSR+C/s8rXH/wCK/V+G5QNj5PPEDGyCok3OTk5XA2NPENSELcGnB2KKxRLhw8fhomkNY52FD04e/asmZmZsbEx1omM5OHhgcwTHh7O3WbBsiXjDurpoKAgalAIyN5wIOWB1lDU2kg85Tc8EBg2Bn8EUFoSKVX0HNhqKDlQzJDnr1yGgvRRaVCPCYjoEQn4g/DLsGHD+CN85BL9/v37NSSej8yePRs+5b7ClYMHD8amRVhCv0sGyWFbvE2BcAITOmz+YPuKngD1wA/olOBVBA5+P4AWi1owrg6qC4Qk8lV6ISHJihUrwsLC6NHWUcba2rm8aREICOIg9TROw9vbG00MNadF0eNksFuQFriRDx8+oKkln+USPWkP+MVPY2Njnz59+EU/5nTs2BHrROfNDYLx48ejneKP7N27F4UQrp+hoSH/vgr2M3ZpQEAAb247Y2Vl5eTkhJCMzYxljxs3jpqAth5+I/+1DWW3vE9DHz58iKvQ4o0ymShqbb+j6FGEYb9qiO/Cos5B94kMxZ+AUufEiROYAAFRL+JFRESgNC8qKhKJRYkqkNw0RGvv6uqKoxUUFEC+0B9aTxwhNjYWPoITkXPRD0yePJm7yYiAMXz4cNJGo+P08vJyd3enXiCZN29e586dqXumZWVl8FdMTAwSMRJUamoqiiViQvGDKo7sNBwTmxmNAS4e/4Zs+2Jrawu39O3bF7WElpYWci81AUEXp4wGJjc3F2GbsgoBzpGsJYSgqLVJFz3kh8uBkhVRD10lBMPdfJNJ20UvEj+n1BCjra0tefcmLy8vKioqLi4OcZffMhLy8/MhssDAQBTTXILDvocKIXEEZmQJHJM7AnyH3BIZGQkrykf+bQFUXPgVakQU5ZIuFonTBZdJ+EDriYmJaKxDQ0Opd7+qqqpwTKT4Xbt24ef4gOaMn0Dal82bNxPPk5hCm8WgxsC0Fks4IeBk/fz86FEBKGpt0kWPMLplyxbIg+gBgsEB6Umt8Euir66uxt/D3y4tLaVtDGWCMIntioKNu9WrcJB19fX1JZ+kykRRa5Mu+l/hl0TP+LNxc3PjnuupHiRw6f8Lsc0w0TPUDiZ6htrBRM9QO5joGWoHEz1D7WCiZ6gdTPQMtYOJnqF2MNEz1A4meoba8Q9saYvHXagOXwAAAABJRU5ErkJggg==>

[image58]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADgAAAApCAIAAADvbn13AAADFElEQVR4Xu2WTUhiURiGLYJaREzQD7SQdOMmCJXobypo0yIkELKgjRjqZoTAXUi0qQihIMiWJkaLcOUqRZOIoojUQMV1UtAii8CCrJwXL3M7nrI8eR1m4D4LOff9vqsP3vNzJbn/BAkd/KuIokIjigqNKCo0oqjQsInqdLrOzs4feZqbm3t6en7+oaurSyaTcSWpVErfWTZsohz9/f0SiWRhYYEu5HLJZHJgYKC1tZUulA2z6PPzc0NDA0Tj8ThdyxONRvHv0mnZMIuenp7CEs/99fWVruXJZDJarZZOy4ZZ1G63Q3R8fJwMX15e+PHNzc3MzAxRFAZm0dHRUYiur6+TodVqfXp64sZ3d3c+n4+sCgKb6IcT9Pb2VqPREF0VgU2Um6D19fXhcBiL5uTkxOPx9Pb2zs7O0q1CwybKTdCOjo5feaanpwcHB5Hs7u7Sre+4vLzc2tpaXFx0OByxWIwLQ6FQQVNx2ES5CbqxsUGGarX6/v6eTChSqdTY2Njw8LDL5cJzOD4+np+fx4KD99DQEN1dBAZRfoImEgkyn5iYIC8jkQh5iWWHvWxtbY0MgdPpxFfZbDYqLwaDKDdBW1paqPzg4IAfY5HNzc3xl5i7NTU1R0dHfMKDbbixsTEQCNCFIjCIchMUxz1dINDr9ZiL3Njr9aIfT7mw5Y2+vj6cDnRaBAbRD3dQEmwCU1NT3Bh/mFwuxwvK4+NjYdcbwWCQjopTquiHOyhJOp1ub28/PDzkLvf29tBsNpsLu75PqaKYTPjhpqam90d8NpvFymhra1OpVHy4srKCfrfbTTSWxRei0MKpo1Qqa2tr8cNVVVXd3d38Oyi2euypdXV1KFVXV29vb/M3Li8vI9zf3ye+rICdnR06+pQvRL+N3++H6ObmJl3Ic3V1ZTAY6PRTKiX68PCgUCgmJyfpQi6H5YXN4eLigi58SqVEwdnZGVb96uoq+RJ4fn6OgxefRGNJVFAUXF9fG43GkZERyFksFpPJtLS0VPreSVJZUR7IYXOgUxb+kmj5iKJCI4oKjSgqNKKo0PwGQNyGHGcvml4AAAAASUVORK5CYII=>

[image59]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACgAAAAlCAIAAAC/AjzkAAAB/0lEQVR4Xu2VTasBURjHh4XwAeQDWPoMUhKxYiHZiLBQXlIWLC0U2Up2Ikt2Ft5WsmJPKRtWSnlJecu9T5TGMzP3zFy3ud3u/Hbz/M/MrzPnnOdQH78EhQtiIYlFQxKLxh8Ub7fbZrNZKBTS6XSlUlksFs+o1WrRBrLzHfF0OnW5XBqNJhAIVKvVfr9fLpftdnsul4O0WCxaLBb8DgNh4uv1mkqllEplJBLZ7Xb06Ha7xWIxt9stl8uz2Sw9YkWAGEw2m02hUDQaDZzdORwOWq2WoqjhcIgzBnzFl8vFbDbDR+Hf4oxGKBRSq9Xn8xkHDPiKo9EoWGEhcfAKLLPJZMJVNniJx+OxTCaDpV0ulzh7pVQqZTIZXGWDl9hoNMJ0PR4PDhiMRqPZbIarbJDF8/mcutPtdnH2BmQxtAiwwpaBs4SzNyCLoUuA2GAw4OA9yGKr1QpiOCc4YLDZbHCJG7LY4XCAOJlM4oCB1+s9nU64ygFZDD0SxE6nEwevwB5MJBK4yg1Z/DjEOp0OBzSgUcNhW6/XOOCGLAbC4TBM+ovLDuY6GAxw9Ut4iff7vV6vh3twMpmgCHqZ3+/vdDqoToSXGDgej3Dhq1SqYDBYr9d7vR7cuz6fLx6PC9rMT/iKH6xWq3a7nc/noSHXajV4xCN4I0z8g0hi0ZDEovH/xJ+CoJUQjmgiuQAAAABJRU5ErkJggg==>

[image60]: <data:image/png;base64,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>

[image61]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA8AAAAYCAYAAAAlBadpAAAAu0lEQVR4XmNgGAUMcnJydfLy8tuA+D8yVlBQOATEDujqwQCoqR1dAy6MohEkADRVAY2/CUkJXByKr4EFgIoy0E0D8YEuiUEWAwEZGRlOrLbDAFDCC6ckA8RgWVlZP3RxMABKLsWlGehKC1xyYIDPWVBbpdDF4QCbZqCNBSAxYDgIIotjAKjmWpghIKyiosKOrg4DABUqQm1lRJcjCKA2fUUXJwpANXujixMEQE3roE4mHcACB118FAwWAAAwo0uqR1jzbAAAAABJRU5ErkJggg==>

[image62]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAsAAAAZCAYAAADnstS2AAAAlElEQVR4XmNgGAV0BQoKChvl5eX/Q/FakBiUfR4op4GslklOTi4NxoFpgrLnwthwSTgHqBGq+DhMDmiyPZI8AgAlvUEKgDb5osthAKDCC2g24QbI7sUKQJKysrI6MDYQT0GWBzpJEMawgZoE8pgn1L1lIDltbW02DFugph0H4seKiopmID4wBHYB6Q8gDSiKRwHNAQCS1y9c2HnLkgAAAABJRU5ErkJggg==>

[image63]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFEAAAAYCAYAAACC2BGSAAADCklEQVR4Xu2XO4gUQRCGbyMRRFHcZN8vBUVMfJ2PQEMRBU1URDET5BJBxMjgArMLNFCQAzHSSFAQxMzEQC8VFMVEETE4TA7BRP9/7Rp7/+3endldTvTmg8Lpv6uqu2r6esepqZycnJw49Xr9lWppQNySav8dKPKnmc4Zbq6geloQ/061vwH2MVOr1Z77NdMajcazZrO5W/0ZcNg5XNU5n06ns3ZQExF/ulqtblM9C8i9iM0/UH25wNoHtHEx6wksl8sVisEOC8EEoFQqbQzpozCpPFlxtd2Rcd9eTIc91LlUDEi8BPus+iiwEJyIo6oPAzHnvAITg/5UfZVisbhG64rV2m63q7G5VMSCqeFPeafqI1IIrTEI+lcqldWqj4OrdVZ14urd1R3gHrtkjYHdEl//6NKe2HPITzUDi5Vc3ILddxxj7Ze8g9SfDMqnwPcbch1UfRxsz0mjPOzEq27NSprIUxVyjDQxenKgz8JmvHESH8nVhTru6O2qh0ADT6o2Llh/PrQ3nnbqwVPvCkqaGCswpNtb8zVDdRff/Y7kMxpwyp83nN8R1ZW0jc5KqE6cwOvU8JWyytcTOAmn2/5Yk8R0+yzwtRj0Y9NVV9x+rqiuwO+i7WmA9V1Tw2Ac1j/r5XirPn24oJGaiNPUUC1Eq9XanMaP0A9pz6uuTPouJHx5affZwzhNNF01giKn7eTB5yPstT+P8V5/bLgmTqseAr5zqo1DrMahaBNRwONQotgCIY34/q4xF2wOl3P5j2cvsXwh4Psdd2Nd9VFxe/6qehQ437dC/YIJTtAxp52AXYZ98P3Q9K1eHo7329jX7V/YPtgnjtHMR3ie7/X+DS9ui0sLPzuQ84bqWcG6W7KuzdOwCXdVDY8FbGS9/tpRQ9LjnOcYz4f4Xzzfx+ls4t2AfoaNwxrrOIbPNYy/DPpxcRf6TdWHgSbuQdyie2GJQb+nvjHgvwB7o/qygJexgRtWfRQmleefhKdAtazwF3lFN5GM2wDE/1BtxYH7bAca8V71NCDuhWo5OTlp+QVc50FH+6BfxgAAAABJRU5ErkJggg==>

[image64]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAD4AAAAYCAYAAACiNE5vAAACfklEQVR4Xu2WO2gUURSGJ4koxle1rOxr9iULrk2KVApaCSlDwNJGFLFRFLuglTaCIGIQ7Ewd0c7GxlaQkFoCNlapBBsb/f/NveudP2eWmd1ls+B+cJi5/3nce+bO3N0omjFjauh2u0fjOL6jehaQ90e1iVKv1z9wEc5eqX8A86MsvlqttkbJHxt5G3eLXlA9D3joV1BnU/WJkrPxOcT+VnEYDn3X8zTuFjun+jC4eX+qPjGGaHws4HV/MbCeW9iGu38D2xOft2+w+5VKpc1xrVb72Gw2a7hfL5VKiz7uX+VEjXewLRw8F3B9SK3RaBQlbtXK97icDs3V/IE13IVdtPKKxeIJS+8Bxwbsu2hs6lY4dtbwGvyXvB5o562JXFziu8VunKXebrePBXFvrXyCZq9GwYHnam4H92aeqWOhXTqMJ58opGOCnT5DDbt/PNQ1zmuwTyl6OM+ulU9Ul7wbuMwH7j6a1wON3/STW+bjdEwKhcJJ1UiaFmdr/MA8Flj3tSxxxIzj60wHd099IdaCuNOqkTQtztA4zwwrX9G8QZhx/L5ckRX1tVqtqr+3Jko7ONK0OEPjuH9u5RM86HOR+5nTPHewPugHB6TV8/9weMic9hrGa9DvBePERKTT6ZxSjaRpqvvDUbSmagTakqux5sY8fF8H/gM5BD1cTvP1gHPLFX4GW0fCTuCj3jf4bquGRTzC9YnqYY1o/x/ZL/ycLeP6khofno+R2AThQ8b1K9bw2Y85N2qWkhn7IGbTqjeVoJH3fAtVHwY2jXqPVZ9axrVL46ozMdxOXVc9D8h/Wi6XK6pPO0dG2S0c1IVR8g8dLP6LalnggafajBn/IX8B0bEOeBO4zfcAAAAASUVORK5CYII=>

[image65]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAAYCAYAAACmwZ5SAAACdElEQVR4Xu2XzWsTQRjGmxraKogtFMV8f0GgoZeCICJ4EaEUTyoeLQUPLejRglAQoQfpzXM9F7z5FxTUv8CDlxyCIJ6Ll0Iu8XmXd8zkycxksynitvnBkJ3n/ZzZ2V0yMzPlAlIul7uspQn032PNC5x/YeywniYKhcLlSqXyhvUhisXiLTg+ZT2N4Kb9xvjB+gBjHYX/nHw+XwiuB8aDoEMKwWn9LKeW9QhZLMYp62lGHk+Mj6xHyIJLpdJD1g2w74sPEizovIfdy7FfCMR8R/y7Vqs1h+s7SU4UenyhcdlarXYN1+1QHq9NDHi7NVgXUGRJ7I1GY17muK7KHGOPfX2o/0BxzDsYB7Y2CslhH1NXXhuvTQ0Z1uUuik1209ZxpzbteQjEH7oKQ3vv0n3o4j44NG8Or81ngN712eIi8digbw79NG5unLLH4lutVm/Yui742NZsxF6v16+zbppadOlxm3KBnPckHo9Lnm2a+y3rLnx9qH6TdYMrJkIM2MUVl+4NigFiN1zxqPVE9Vm2uXD1gU1cNRo2djuXy12x7QLH/EUT7jv0E1cQtK55q5tmUHCZ/QSNH3g/aMxrM8exK5o8tp8BtV6xTf2jTynbBNkAlx4RKHZJdHMksZO3MW/bx9/EoqmX/bA+sK2V9Q+JeePj977tI1+AQA8RYjMvT82xq/5Z/D4id6n1HPpX1iN0Id5io0DsOsYW6+MySQ/MyFwjHQIg9gtrSZikBxt5vOLkysCpw2IMMvLZYHFc5AiylhRZLD5hD1gfAo4nKHyX9RB4HJ6xlgTU/slaQrLo6ROLXs5yp/81zWbzKjbuiPUpU84pfwAWk8DTMK+EEQAAAABJRU5ErkJggg==>

[image66]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAgAAAAZCAYAAAAMhW+1AAAAcUlEQVR4XmNgGAUYQFxcnFteXv4/ED+E0ovhknJycqkgQRgfyF4N58vKykqBOAoKCgJICkAmQBQAGd+RdWMAqOomdHEwABrrgVe3kpKSGl4FIABUcBXoizQ0sZtAPAVZAOSOw0C8FcRWUVHhQ1I/4gEAHishD09kYlgAAAAASUVORK5CYII=>

[image67]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAkAAAAaCAYAAABl03YlAAAAh0lEQVR4XmNgGAVkAUVFRXF5efnvQPwVyGVBl2cASrwDKQAyGYGYCcj+D8SSyAr+y8nJhcEFoGIgDOOshnOQALqi/woKCgvR1CAUASXdoaoxHAlXBCSCsVkFAlBFXiA2IzZFQLFlQPwGLgC00gEo8AxJAciErXAFSBLJQHwEqGEmutwoIA4AALPDKjAGDC/3AAAAAElFTkSuQmCC>

[image68]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAZCAYAAAAIcL+IAAAAj0lEQVR4XmNgGAVUB3Jycj7y8vL/gfgIENcC8TQVFRV2dEUrQIpgfCD7HZTPCFekqKioDxVkgYkBNdYjawQDqHUogtjEGEECCgoKlciCGAqBVoRiuIUBohAo1w4XkJWV1UG3AgRAYjIyMipArApk98AFYcFgbGzMimwtuiFgdwLxMpgzoPw7QJyNrHAUUAYA1HEv6Gavfg0AAAAASUVORK5CYII=>

[image69]: <data:image/png;base64,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>

[image70]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA8AAAAZCAYAAADuWXTMAAAA10lEQVR4XmNgGF5ARkZGRUFB4ZS8vPx/GNbW1mYDyQHZSUBsiK4HDOTk5BaAFAM1LwQaogoSA9KcIDFRUVEeEI2uBwygtjxGF4cBmCvQxXFLIAGommJ0wauENIIA0CszQU5HESTGVhAAal6JIgAMoFSQRqBEA4oEMYBYW7ECumgGeu+gkpISP4ogUON3YjQDw2QTuhhIsxVIs7Kysiy6HAwA5bvQxeAAKPkLZADQaYJY5EAxwYEujgKAiibD/A+KTyj7Hro6nABkM1CDo6Kioh663CgYsgAA8D5CH963SdYAAAAASUVORK5CYII=>

[image71]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA8AAAAYCAYAAAAlBadpAAAArElEQVR4XmNgGPRAXl7+P7oYUQCocTMlmv+TpVlOTq6NLM1ADZ5AfF9BQWETOZpBGliAdCtJmkGKZWRkhEBsWVlZPxAf6AUtdHVYAVDxCSS2IUgz0Pn+yGqwAqDCZ8h8oCYOqOYOZHEMAFSkCVKIA29HV48CQIrQxUAAZgC6OBxIS0sLA52mgC4OAng1A/Uk4pRkwKEZGA1SSH7CUAA0NBxdHognI6sZBcMbAAAHGEE6SxnD8gAAAABJRU5ErkJggg==>

[image72]: <data:image/png;base64,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>

[image73]: <data:image/png;base64,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>

[image74]: <data:image/png;base64,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>

[image75]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEwAAAAYCAYAAABQiBvKAAAC8UlEQVR4Xu2Xz6tNURzF30uUDIh049wf7o/y4xblJopiyMBA0nsTlFAMDJgZEEVJFFNk8AbmlJhKmSjl/QFvZvx6E/Umz1rP3rdt3X323veeQ+J86gzuWt/v2j/u+Tk1VVHxx2m1Wsuq/S9g7SuqBUHDNxxXVXfZARhsj3q9vjnLsi2QX2ttDDfHdyBzVnsmod1u70XegpM9j2O/1jUajS591b2g+AAmOKO6ixnslKs1m8331DudzkZXHwe7kFQ9FcztDPuxYfvUM9lvVMceHIM+p/oIsYlh8MuoeaE6ifXGMJMfycbkjxvvgnox0LuJvZj3NfUIrowefd8fHV0PCh7GikI+zzLVUkHuDWb3+/116iH3Nj0s/oF6IXi1mI3erZ6LqRlZl9GXVB9iCr6rboG3zdScVo9gYQPVUuG4vkkTZ0Fr1Avh9AXJq8Mf9MSnD6GJRZ9U3cWGm9pb3W63oTWTYPJeqk7MeF9UD4HFHjR9r9RT7HpUr9VqG3z6EJq8plV34RPLDmAPaF+1bhzspYMN2+Pq0G6a/POungL6Fk3vLvUUuw7VSZ6+ijGnVc8DC3znbpz6qaB3qUi/j9Q5oeYt67CWS+qRYEbQDJA6uTyK9vtIzYzVhbxVk49h1Qm8R6pZYoPGKNrvIyWz9fMFfWUwGKxVzxLMoKn3EUuo0UzuseqpmP551YuQuGGsCX4CBjNMwD3VwTQ9bOZhNaCdhfdJdZIyaZzRd1iDG/929UKkZNNH/gfV+SCg53vzd0Hd0eAYeZNA44z1cDx19OB7Sl4egf7MyRweWpeHrcccDqlngf+RNfw2tBr+4HOm74pb6wN1c8E5cXBfAbSL8vtE3lNFQe1n1coC2Xf5Qa26gpqdWNts3u0mD+4FvzJU/wXfhhWh7DyX35lNUvN5v1pQcRKQs4wX4fWqlwE/lmMv2UXAmXU/y7K66l6w0EU0HFF9XJBzXbWyQPZz1cqi1+ttTT27hqTeo/5F+I2sWkVFxV/LDzneHOv20r8CAAAAAElFTkSuQmCC>

[image76]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAAAYCAYAAABKtPtEAAACmUlEQVR4Xu2Xu4tTURDGsw8V8VXFqCS5eUGKIChpBEUEGwvtFGEXBAsrwUbRQlCwFfaPEHYba0H/AkULKwWrNLKVhSzY2KzfZO9c5nyec/fcJHur+4NDzvlmzpyZyX0ktVpFRS1JkrcYu2a8yRlb5LvJ8Q4CnPODtRiwb6fb7Sas/8dgMDipRbHNUq/Xj8f4xWKbyTYFtm3WipAX22G/RITYBsD+XXza7fYztjHwexKKJ3qn07nLekGWQvEdYgqLbQAKv54mf4ZtDHwfhOKF9KJIHNwKQ9YdYgqLbUAR0KT7vnjQXqM591ifBcR54TvDIaawkhuwi2fTEdZnodlsDnxnOMQUFtsA9ZHiSH8uutwi/X7/NOY7GO988XyaAtsvjDVMV9N4L/H5CeuV0L6QnqFJs26JbYAgPp4GyL14lbQJx8O+C6wZVmG/pItkrxlT37zcRB+NRodZz8jbrMzTgNA+aK9Ylyc/awr0n7SWK+B2Ol9vtVrnrF0RP9wK51nPCCVoKasBKOgRawH0FbfEBibN5wbrGaEELWU1APuuseYDPhsxfoL45b4KQwla5mzAxLfP1wCsu6wpuIyPDofDEzL35YL1F7tWxK/X651iPcMXjJmnAarh8r5lpOVQPJ8mpP7fzDzzw3mfO4EfX6F4GRzMR2QDpq8iO9SA+WNZowk3pRGYf0zSK0CGfUrLutFoHNO11dPPh4hxR9eYX8F46nrvAZ+LNg8vJtlltimRDVgI8qpDQR9YnwXku43xl3UHU9gK25QyGyAs6hyJg2ZeZt1BCxuPx4fYppTdACT9HmdNWC8C9p+V/wKsO8jrQQtr5/yFTROa+uX+qlogOOs3a0XY98vSgnjM6ncQ4Jw/rMWAfV9Zq6ioyPgHZ3NDL//XxuMAAAAASUVORK5CYII=>

[image77]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACMAAAAWCAYAAABKbiVHAAABq0lEQVR4Xu2WvUrEQBSFY2UjiD9BzH9CRBBsRVGxEUGwENfKUrCzEAvxAay1sBHBd/AB9Bm0shHWQh9ABBFs9FydwOzJZJOgaxo/GJace+beM8mGXcv6548Iw7DNWhnY88FaB57nTcB0K0a17rHm2KeD+k0QBGesZ7iuO8KaEMfxJPa+sW75vr8ow2FY4ZoKdcW6gBBDqB2xjj4z0E+zQ3E9A7VV1r4GovEJ6wIaj0nddELor6wJ0J+xdtFzp1uYDnBHHBVkk2s6phPieos1plYY0xATJp9JYyqHSZJkUDV84BpjGizXURQd6hpTOQyMl6rhOtcYDpOmab9co8ea7mMqh+EBRcBzrrz7mYYhU6LJ66l7mV6EyflwN5dEcxxnVNeZXw2D+p14bNse0HU8Jlt0hJrVdaZOmKcyY7fAqtZiXadyGEE1fGQdPwuu1NBsgWsZau816zp1w1yoofOatqG0A93LyCGKBqmguYXHusfeHDDGWC3ckWmuFQHvcFGYRkCYF3z0sd4YCPTOWlWw95i1HxF+/+fZZr0M7BnvyWPGl32ZtTLKXpBG+ATGRpmEp5XeJwAAAABJRU5ErkJggg==>

[image78]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAYCAYAAAC8/X7cAAACR0lEQVR4Xu2WPUhbURiGU9Aq6NLWEEzuzQ/JFrBgpg6SSTJJJXOnzu3QpWMptNipoTo4ddJRdOtS6Nq5IA6F4hhEujvq+13OKV/efOf2kh8HzQOHm/u+3885J/fcJJebcceoVCrXrI3LSDVLpVKExJ+S7Ea/Wq12OE4D/0u5XH7EuqDqJMPw+6GYOI7rqN3W8UEwgZYr0GXP6X9YF6CfYPxmnfGTi6LoMXuCnrjG5R2yPoQLPGBdaDabD52/zp7ojUYjz7oGu7iNb/aJq3HGvgB9jzUBG7sVWlxCsVhccYVfsqdxMQOFcL+KcaE1C5+HhXyXz7hWtV+v12NcHmhNIzmyiawnWBOzsOJwf4wdeq01C5/XarXmXZ2+9lFjR98zWO8ucl6xnsvn88uu4CV7TGAB/124PAIYn/z9KHUKhcKSGQPxSAw0eMEeM0pjATG/8DYp+nv/GOlzk7HOcIw1KQs0feNiB94GWXKtGN0X1x7qP+cYxqqTeQEq7t9BQ9PFjLmnhvZZcmu12lqWGoIZl2UB8L9JjHtTsJeaK8gPI2uC752lhmDGQTw3DUVak5Dukfc/ax61gA/sWQR7uSJ/WZe/BuKlHXDx9QFlgk0BHp+nab4GG9FG7BXrCTD23UQ3vYaEjlvYRx3LwO8h762hS+7A4BghpDOIO8Sc3rM+AHYEcZWuHCz20sg6iXGYag8pLotnfVL4p4H1iYEzsDHNBlI79CabGGjyFZc51sdFfq1xxt6xPhWwiB9ouMD6qKDes1ub/Iz7yA2yqdCCDmyFDgAAAABJRU5ErkJggg==>

[image79]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABcAAAAYCAYAAAARfGZ1AAABCElEQVR4Xu2UvQ4BURSE9QrlJrL/kYhEg0Sl0AsSFBqlXu8BvIZHEK+g1xGVRO8JNMxJzm42g3UXlfiSm93MzJn9uZvN5f5kIQiCsud5O6yrrj1WnXOZ8H2/LWWu67bYiy7EujFavGBdsG27JL5lWXn2UnEcp6jFXfaSvHX3pkOmuZgwDAs6dGCPyVyOTVzrUIc9JnO56QD2YyU5HCdJHVoNe9ZLajGm5ZzD+TzSPiqHf9Lc5oGXWn42KJfiC+tCarmgw8cHeiAe3nODvYiX5RheSgj/lGak4Ssai4bjLJllNNNn/Q5cJMQa4U6q7D1Dn3rA+lfQ8iHrH4HCCp5yquVbOefMnx/iBuaIX682QzQKAAAAAElFTkSuQmCC>

[image80]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABcAAAAYCAYAAAARfGZ1AAABMUlEQVR4XmNgGAWkAEVFRXV5efmrQPwfiq8BsRG6OpKAgoKCA8gwOTk5G3Q5mEXo4kQDqMHt6OIgICMjowKSFxcX50aXwwtkZWWloAb7osshA7JcT6wmYtXBgZKSEj9U0w10OXRAsuHASNwE1eSNLocOSDacWA3A+NgAUgekY2Fi0Eh+CBTLQ1YLB8Qajq4OyA4CJV0QG2j4TiC/G64YBtA1YQMg10HVHUYSQ7fsv4qKCjuMDxN8Q4ThIIN+oYndBOJiZDVAihFJCUICiO9hEVcEyQG9bYwuhwyAwZMJVLcUXRwMgJoXgAwBlilmMDGghgiQGJAuQFaLDRDyORgALVEC4hBgjtVBl8MFgAZPBtFAR3AYGxuzosuTDUCpBMYGGp6AJEUZgMYTCkZXMwqGEQAAN4plBarQFAIAAAAASUVORK5CYII=>

[image81]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFwAAAAeCAYAAAChf3k/AAADZUlEQVR4Xu1ZO4gUQRDdkwM/CCq4wg2727N7K4omBioGggf+UFHUQOEUM0FEDzERDDQR1ERBMDDWSMFDQdDIQDA6TsFEQQTxMDAwMBFMzvfWKmhr+ub2A7OznwdNV72q6emq7umZrS0U+hxxHK9Gm7C8hXPuoeXaQbFYXIn7PbD8wACJvIE2b3kfsJ+ynAK2MSTwNseoVConrD0E+ltuoLBIwkdg/2VJPhmh60JcCPB7YrmBQVqSYLuDnXsxwM+Xy+UoxMN/j+Ut0u6Zd3AHfsWOe4Z+mgQCviuB70b/gXKpVFoPfRPkFzZY6rj+HPpPIk/4Ns9VuS9oxy1P0B/tqeUtZH5rLJ97cOJRFK2ljACuoRtR3k8WZezIbSJPIqmxb0O3xOgJOY1TSCJPW96CfpjCFsvnHppYbQj2ivII6JLvpzL4XWj7QzbRZ3URrQ3jH7acol6vF31btVrdjrbB91HAb8alvIwT4PnlB2rtWWGhe8u8zvu6ykjaTugHQzbR33pPw3+28fHxdZZTgP/DxaRcq9Uq7FMS3tRZn4AE9t7yWYH3R5AbPf2Q8ghoyvdTmWc0d2rIZnXK2LlLjf2NPX8lD5d9jkhLeEGOv5YgNwq+QLIAAnIyhwNoM+TkZUnuO9RR6Gepo7/JuSLhj9F/RJukv/jO8kwV+YKOD/kRrjujusc3jiz0VyljR6+yPsQiCW8N3CltXdhj6CRGfhlZjsCYxyy3KHDR604m0ytwHfysx6bcEeBOWi4BfMcuZ3KxYpupy6PHx+qo9e1HINYflmsHOGL24YW81fIJSII/q45EP29md8NnThenmYYFfWnHGDjw25bJ8Dno05bLEnaher2FgnsX4LqW8L4FkjrGxOKDv2x4Jvybz/Ui4rzVw92/79vETpaEN75jMcAta1e4nJ/hLof1cFbj7PndqMBRxk1eYYBlvr3XYOMzyL4eDuM9JPa6yD/R7nPgKIpWoP9t/XsNaUlyw3p4AsN6eJbgxIf18AyhidXG3wzKx12sh8NvrxTW5lgXt76u1Xp4XrBQ8LIAXauH00fKuqMhf3LNnPW5Ayce57gejoU74gL/F8g9Wq+Hdxt5r4fTZjliIX6IQvvJcVIO4YIHbK3XwwcFro2f9U4+P7X5triZevigw2VdDx8iG/wFLBruCVfTpWAAAAAASUVORK5CYII=>

[image82]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABcAAAAYCAYAAAARfGZ1AAABSElEQVR4Xu2Uv0rDUBTGK3Sr4BQCkv8RpKWTopOIuzjVQSj1GfoMXbq1Q4dCJx9BfAXfQFCcCm4OPoGLfkfOjdePi9xEcOoPDrn5zne+9CZNWq0NdcjzfD9N00fUh9YT6oB9tciy7EzCkiQ54Z65EOveaPCUdSGKoj3ph2HY4d6vxHG8q8EX3LNp9Ot9h3x9FUVR7OjQM/eY2uF4iHc6dM49pna47wCex634cBxZWg/aK2pieyt8w9mHd+EU5wNZ4yLXqOW3W+EhF+i/qO/eaLidD9Zc25kB8c3ZsNDgd9YNsgPUgvUvdHjt0HPpYcuH3DPo7Ir1CgzfiAn38dho2PaVaDiOba8L+IbImLP+AxgK1CXe2D73GHiOcGibc91B17I0R8OqZyXrsixj29MYhM3kIxcEwTbWa/k7suevbEmofP+5seH/+QRzDWUU8inOewAAAABJRU5ErkJggg==>

[image83]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABcAAAAYCAYAAAARfGZ1AAABFklEQVR4Xu2UvYrCUBCFxdbCMiD5R7CxUrCy2H6RbSxsLK3X0jfwNXwEtdbKRuxdrITtfQKb9UyYK/Fgws1qJX4wueGcmZN7E7RUelOEKIoaQRDsUX9aP6gW9xUiDMMPCfN9v8ueeRDr1mjwlHXBdd26+I7jVNjLxfO8mgb32Evzr93bDtn2XYnjuKpDB/aYwuH4iEsd+mSPKRxuO4DvMZc+rMM73jdrCbbheX1Zeu6QAf6v9m3Yw2vdQd+yngDjZBEuwWfWQVkumeGCDh/v6JF4eKdt9gR4a12zwzE8kxD8p3SMhuMORMM6Tvca4K1S99nhBjwkRvXxi22yx+hpbwobWXDfw0gwa08BJx3prieoL/bfvAgXlM1gijAS6IwAAAAASUVORK5CYII=>

[image84]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAYCAYAAADDLGwtAAAApklEQVR4XmNgGHxAVlZWSl5e/j8Mo8tjAKjCC+jiGACqMAhdHAUoKCg4EGvtfgyFMjIynCBBOTk5bagisCeApgagKIRK3IHxgQo2YZgGNKUcXRDIX48uBjPtPBYxhEIgRxIkoKysLIukDqbwMbKAJ4YVEHGQwigQG+jeDhDNiK4QyL8MEwO6fydQIQdMYhJQoB7KfgfEU0EKpaSkuID0dyQzRgGFAABbmjhuxRY4PgAAAABJRU5ErkJggg==>

[image85]: <data:image/png;base64,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>