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

[Base Model Representations](#base-model-representations)

[RDF Model Representation](#rdf-model-representation)

[Sets Based Model Representation](#sets-based-model-representation)

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

@deprecated: Occurrence with role of SubjectKind type  
class Subject extends Occurrence  
\+ role : SubjectKind

@deprecated: Occurrence with role of PredicateKind type  
class Predicate extends Occurrence  
\+ role : PredicateKind

@deprecated: Occurrence with role of ObjectKind type  
class Object extends Occurrence  
\+ role : ObjectKind

Context: Root Context ContextKind (all Statements Context’s Occurrences)

Subject: Root Subject SubjectKind (all Statements Subject’s Occurrences)

Predicate: Root Predicate PredicateKind (all Statements Predicate’s Occurrences)

Object: Root Object ObjectKind (all Statements Object’s Occurrences)

interface Kind\<PlayerType extends Occurrence,  
          AttributeType extends Occurrence,  
          ValueType extends Occurrence\>

class ContextKind extends Resource implements Kind\<Context, Subject, Object\>

class SubjectKind extends Resource implements Kind\<Subject, Predicate, Object\>

class PredicateKind extends Resource implements Kind\<Predicate, Subject, Object\>

class ObjectKind extends Resource implements Kind\<Object, Predicate, Subject\>

## Resources {#resources}

Everything is a Resource identified by an URI, assigned a Prime Number ID, keeping track of its Occurrences and thus enabling the calculation of their CPPE (Prime Number Contextual Embedding) by means of the product of its Prime Number ID by the Prime Number IDs of the other Resources in their Occurrences contexts.

## Occurrences {#occurrences}

Participation of a Resource in an Occurrence in a given Role (Kind) in a given Context (Statement, Kind).

### Statement Occurrences {#statement-occurrences}

Statements are Resources whose occurrences are their CSPOs in a given Role (Kind?)

### CSPO Occurrences {#cspo-occurrences}

@deprecated: CSPOs are Occurrence(s) with their corresponding Statement position Kind types (ContextKind, SubjectKind, PredicateKind, ObjectKind) Statement Occurrence roles.

Context, Subject, Predicate, Object as Resource(s). SPO occurring Statement Contexts where they are in C, S, P, O Roles.

CSPOs instances as wrapped arbitrary Resource Occurrence Context

### Kinds Occurrences {#kinds-occurrences}

As Context, Subject, Predicate, Object. Occurrences: Kind Functional Definition Statement Contexts (occurring Statement Contexts)

Kinds as Resources: Kinds occurring in Statements in C, S, P, O Roles

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

Contexts Set (Universal Set: Subjects, Predicates, Objects and Subjects Set, Predicates Set and Objects Set union).

Subjects Set.

Predicates Set.

Objects Set.

Context Kinds Set (Subject Kinds Set, Predicate Kinds Set, Object Kinds Set union).

Subject Kinds Set (Predicates Set intersection with Objects Set).  
      
Predicate Kinds Set (Subjects Set intersection with Objects Set).  
      
Object Kinds Set (Subjects Set intersection with Predicates Set).

![][image1]

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

See Homoiconic approach. TODO

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

See Homoiconic approach. TODO

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

See Homoiconic approach. TODO

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

Let ![][image2] be the set of unique Prime IDs assigned to Resource URIs.

For any ContextPoint ![][image3]:

* ![][image4] (The singleton identity).  
* ![][image5] (The cumulative embedding).

### 

###### *The Prime Product Rule:* {#the-prime-product-rule:}

The embedding of a triadic occurrence ![][image6]—where ![][image7] is Context, ![][image8] is Object, and ![][image9] is Attribute—is defined as the product of their respective recursive embeddings:

![][image10]

Because every factor is a prime (or a product of primes), the result is a unique "coordinate" in the integer space that encodes the entire lineage of the relationship.

##### 2\. Pipeline Stream Operators (The CPPE Monad) {#2.-pipeline-stream-operators-(the-cppe-monad)}

In a reactive stream (e.g., Flux\<FCAContextPoint\>), the following algebraic operators are used for "Stream Action":

###### *A. The "Contains" Operator (Sub-graph Filtering):* {#a.-the-"contains"-operator-(sub-graph-filtering):}

To check if a stream of Objects belongs to a certain Context ![][image11] or possesses an Attribute ![][image12]:

* **Logic**: ![][image13]  
* **Reactive Implementation**:  
  // Filter objects that are part of the 'Accounting' context  
  objectStream.filter(obj \-\> obj.getPrimeIDEmbedding().remainder(accountingID).equals(BigInteger.ZERO));

###### *B. The "Intersection" Operator (Aggregation):* {#b.-the-"intersection"-operator-(aggregation):}

To find commonalities between two streams (finding the "Type" or "Concept"):

* **Logic**: ![][image14]  
* **Stream Action**: The Greatest Common Divisor (GCD) of the embeddings of two nodes represents their shared FCA attributes/contexts.  
* **Aggregation Use Case**: When the stream encounters multiple SPO triples, it calculates the "running GCD" of the attributes to infer the Schema (the most specific common super-type).

### 

###### *C. The "Axis Shift" Operator (Alignment):* {#c.-the-"axis-shift"-operator-(alignment):}

Alignment predicts a value for a new context by calculating the "Ratio" of change between existing embeddings.

* **Logic**: ![][image15]  
* **Stream Action**: By dividing by the "Old Axis" prime and multiplying by the "New Axis" prime, we re-project the object into a new coordinate.

##### 3\. Pipeline Stages Revisited via CPPE: {#3.-pipeline-stages-revisited-via-cppe:}

###### *3.1 Aggregation (Algebraic Type Inference):* {#3.1-aggregation-(algebraic-type-inference):}

The Aggregation pipeline consumes raw SPO streams and produces **"Type Tensors"**.

1. **Input**: Stream of rotated triples ![][image16].  
2. **Action**: For all ![][image3] sharing attribute ![][image9], calculate the product ![][image17].  
3. **Inference**: If ![][image5] is divisible by the product of a set of attribute primes, ![][image3] is classified into that Type.  
4. **Complexity**: ![][image18] lookup via modulo instead of ![][image19] graph search.

### 

###### *3.2 Alignment (Vector/Prime Space Prediction):* {#3.2-alignment-(vector/prime-space-prediction):}

Alignment uses the **Prime Ratio** to detect structural similarity.

1. **Input**: Aggregated Types.  
2. **Action**: Map the distance between objects ![][image20] and ![][image21] as ![][image22].  
3. **Discovery**: If ![][image23] and ![][image24] share the same ratio ![][image25], the system aligns them as being "analogous" in different contexts (e.g., "CEO is to Company A what Principal is to School B").

### 

###### *3.3 Activation (State Transition Product):* {#3.3-activation-(state-transition-product):}

Activation is the "Activation Energy" required to move from one prime state to another.

* **Transition Formula**: ![][image26]  
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


[image1]: <data:image/png;base64,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>

[image2]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA8AAAAYCAYAAAAlBadpAAAAu0lEQVR4XmNgGAUMcnJydfLy8tuA+D8yVlBQOATEDujqwQCoqR1dAy6MohEkADRVAY2/CUkJXByKr4EFgIoy0E0D8YEuiUEWAwEZGRlOrLbDAFDCC6ckA8RgWVlZP3RxMABKLsWlGehKC1xyYIDPWVBbpdDF4QCbZqCNBSAxYDgIIotjAKjmWpghIKyiosKOrg4DABUqQm1lRJcjCKA2fUUXJwpANXujixMEQE3roE4mHcACB118FAwWAAAwo0uqR1jzbAAAAABJRU5ErkJggg==>

[image3]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAsAAAAZCAYAAADnstS2AAAAlElEQVR4XmNgGAV0BQoKChvl5eX/Q/FakBiUfR4op4GslklOTi4NxoFpgrLnwthwSTgHqBGq+DhMDmiyPZI8AgAlvUEKgDb5osthAKDCC2g24QbI7sUKQJKysrI6MDYQT0GWBzpJEMawgZoE8pgn1L1lIDltbW02DFugph0H4seKiopmID4wBHYB6Q8gDSiKRwHNAQCS1y9c2HnLkgAAAABJRU5ErkJggg==>

[image4]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFEAAAAYCAYAAACC2BGSAAADCklEQVR4Xu2XO4gUQRCGbyMRRFHcZN8vBUVMfJ2PQEMRBU1URDET5BJBxMjgArMLNFCQAzHSSFAQxMzEQC8VFMVEETE4TA7BRP9/7Rp7/+3endldTvTmg8Lpv6uqu2r6esepqZycnJw49Xr9lWppQNySav8dKPKnmc4Zbq6geloQ/061vwH2MVOr1Z77NdMajcazZrO5W/0ZcNg5XNU5n06ns3ZQExF/ulqtblM9C8i9iM0/UH25wNoHtHEx6wksl8sVisEOC8EEoFQqbQzpozCpPFlxtd2Rcd9eTIc91LlUDEi8BPus+iiwEJyIo6oPAzHnvAITg/5UfZVisbhG64rV2m63q7G5VMSCqeFPeafqI1IIrTEI+lcqldWqj4OrdVZ14urd1R3gHrtkjYHdEl//6NKe2HPITzUDi5Vc3ILddxxj7Ze8g9SfDMqnwPcbch1UfRxsz0mjPOzEq27NSprIUxVyjDQxenKgz8JmvHESH8nVhTru6O2qh0ADT6o2Llh/PrQ3nnbqwVPvCkqaGCswpNtb8zVDdRff/Y7kMxpwyp83nN8R1ZW0jc5KqE6cwOvU8JWyytcTOAmn2/5Yk8R0+yzwtRj0Y9NVV9x+rqiuwO+i7WmA9V1Tw2Ac1j/r5XirPn24oJGaiNPUUC1Eq9XanMaP0A9pz6uuTPouJHx5affZwzhNNF01giKn7eTB5yPstT+P8V5/bLgmTqseAr5zqo1DrMahaBNRwONQotgCIY34/q4xF2wOl3P5j2cvsXwh4Psdd2Nd9VFxe/6qehQ437dC/YIJTtAxp52AXYZ98P3Q9K1eHo7329jX7V/YPtgnjtHMR3ie7/X+DS9ui0sLPzuQ84bqWcG6W7KuzdOwCXdVDY8FbGS9/tpRQ9LjnOcYz4f4Xzzfx+ls4t2AfoaNwxrrOIbPNYy/DPpxcRf6TdWHgSbuQdyie2GJQb+nvjHgvwB7o/qygJexgRtWfRQmleefhKdAtazwF3lFN5GM2wDE/1BtxYH7bAca8V71NCDuhWo5OTlp+QVc50FH+6BfxgAAAABJRU5ErkJggg==>

[image5]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAD4AAAAYCAYAAACiNE5vAAACfklEQVR4Xu2WO2gUURSGJ4koxle1rOxr9iULrk2KVApaCSlDwNJGFLFRFLuglTaCIGIQ7Ewd0c7GxlaQkFoCNlapBBsb/f/NveudP2eWmd1ls+B+cJi5/3nce+bO3N0omjFjauh2u0fjOL6jehaQ90e1iVKv1z9wEc5eqX8A86MsvlqttkbJHxt5G3eLXlA9D3joV1BnU/WJkrPxOcT+VnEYDn3X8zTuFjun+jC4eX+qPjGGaHws4HV/MbCeW9iGu38D2xOft2+w+5VKpc1xrVb72Gw2a7hfL5VKiz7uX+VEjXewLRw8F3B9SK3RaBQlbtXK97icDs3V/IE13IVdtPKKxeIJS+8Bxwbsu2hs6lY4dtbwGvyXvB5o562JXFziu8VunKXebrePBXFvrXyCZq9GwYHnam4H92aeqWOhXTqMJ58opGOCnT5DDbt/PNQ1zmuwTyl6OM+ulU9Ul7wbuMwH7j6a1wON3/STW+bjdEwKhcJJ1UiaFmdr/MA8Flj3tSxxxIzj60wHd099IdaCuNOqkTQtztA4zwwrX9G8QZhx/L5ckRX1tVqtqr+3Jko7ONK0OEPjuH9u5RM86HOR+5nTPHewPugHB6TV8/9weMic9hrGa9DvBePERKTT6ZxSjaRpqvvDUbSmagTakqux5sY8fF8H/gM5BD1cTvP1gHPLFX4GW0fCTuCj3jf4bquGRTzC9YnqYY1o/x/ZL/ycLeP6khofno+R2AThQ8b1K9bw2Y85N2qWkhn7IGbTqjeVoJH3fAtVHwY2jXqPVZ9axrVL46ozMdxOXVc9D8h/Wi6XK6pPO0dG2S0c1IVR8g8dLP6LalnggafajBn/IX8B0bEOeBO4zfcAAAAASUVORK5CYII=>

[image6]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAAYCAYAAACmwZ5SAAACdElEQVR4Xu2XzWsTQRjGmxraKogtFMV8f0GgoZeCICJ4EaEUTyoeLQUPLejRglAQoQfpzXM9F7z5FxTUv8CDlxyCIJ6Ll0Iu8XmXd8zkycxksynitvnBkJ3n/ZzZ2V0yMzPlAlIul7uspQn032PNC5x/YeywniYKhcLlSqXyhvUhisXiLTg+ZT2N4Kb9xvjB+gBjHYX/nHw+XwiuB8aDoEMKwWn9LKeW9QhZLMYp62lGHk+Mj6xHyIJLpdJD1g2w74sPEizovIfdy7FfCMR8R/y7Vqs1h+s7SU4UenyhcdlarXYN1+1QHq9NDHi7NVgXUGRJ7I1GY17muK7KHGOPfX2o/0BxzDsYB7Y2CslhH1NXXhuvTQ0Z1uUuik1209ZxpzbteQjEH7oKQ3vv0n3o4j44NG8Or81ngN712eIi8digbw79NG5unLLH4lutVm/Yui742NZsxF6v16+zbppadOlxm3KBnPckHo9Lnm2a+y3rLnx9qH6TdYMrJkIM2MUVl+4NigFiN1zxqPVE9Vm2uXD1gU1cNRo2djuXy12x7QLH/EUT7jv0E1cQtK55q5tmUHCZ/QSNH3g/aMxrM8exK5o8tp8BtV6xTf2jTynbBNkAlx4RKHZJdHMksZO3MW/bx9/EoqmX/bA+sK2V9Q+JeePj977tI1+AQA8RYjMvT82xq/5Z/D4id6n1HPpX1iN0Id5io0DsOsYW6+MySQ/MyFwjHQIg9gtrSZikBxt5vOLkysCpw2IMMvLZYHFc5AiylhRZLD5hD1gfAo4nKHyX9RB4HJ6xlgTU/slaQrLo6ROLXs5yp/81zWbzKjbuiPUpU84pfwAWk8DTMK+EEQAAAABJRU5ErkJggg==>

[image7]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAgAAAAZCAYAAAAMhW+1AAAAcUlEQVR4XmNgGAUYQFxcnFteXv4/ED+E0ovhknJycqkgQRgfyF4N58vKykqBOAoKCgJICkAmQBQAGd+RdWMAqOomdHEwABrrgVe3kpKSGl4FIABUcBXoizQ0sZtAPAVZAOSOw0C8FcRWUVHhQ1I/4gEAHishD09kYlgAAAAASUVORK5CYII=>

[image8]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAkAAAAaCAYAAABl03YlAAAAh0lEQVR4XmNgGAVkAUVFRXF5efnvQPwVyGVBl2cASrwDKQAyGYGYCcj+D8SSyAr+y8nJhcEFoGIgDOOshnOQALqi/woKCgvR1CAUASXdoaoxHAlXBCSCsVkFAlBFXiA2IzZFQLFlQPwGLgC00gEo8AxJAciErXAFSBLJQHwEqGEmutwoIA4AALPDKjAGDC/3AAAAAElFTkSuQmCC>

[image9]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAZCAYAAAAIcL+IAAAAj0lEQVR4XmNgGAVUB3Jycj7y8vL/gfgIENcC8TQVFRV2dEUrQIpgfCD7HZTPCFekqKioDxVkgYkBNdYjawQDqHUogtjEGEECCgoKlciCGAqBVoRiuIUBohAo1w4XkJWV1UG3AgRAYjIyMipArApk98AFYcFgbGzMimwtuiFgdwLxMpgzoPw7QJyNrHAUUAYA1HEv6Gavfg0AAAAASUVORK5CYII=>

[image10]: <data:image/png;base64,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>

[image11]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA8AAAAZCAYAAADuWXTMAAAA10lEQVR4XmNgGF5ARkZGRUFB4ZS8vPx/GNbW1mYDyQHZSUBsiK4HDOTk5BaAFAM1LwQaogoSA9KcIDFRUVEeEI2uBwygtjxGF4cBmCvQxXFLIAGommJ0wauENIIA0CszQU5HESTGVhAAal6JIgAMoFSQRqBEA4oEMYBYW7ECumgGeu+gkpISP4ogUON3YjQDw2QTuhhIsxVIs7Kysiy6HAwA5bvQxeAAKPkLZADQaYJY5EAxwYEujgKAiibD/A+KTyj7Hro6nABkM1CDo6Kioh663CgYsgAA8D5CH963SdYAAAAASUVORK5CYII=>

[image12]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA8AAAAYCAYAAAAlBadpAAAArElEQVR4XmNgGPRAXl7+P7oYUQCocTMlmv+TpVlOTq6NLM1ADZ5AfF9BQWETOZpBGliAdCtJmkGKZWRkhEBsWVlZPxAf6AUtdHVYAVDxCSS2IUgz0Pn+yGqwAqDCZ8h8oCYOqOYOZHEMAFSkCVKIA29HV48CQIrQxUAAZgC6OBxIS0sLA52mgC4OAng1A/Uk4pRkwKEZGA1SSH7CUAA0NBxdHognI6sZBcMbAAAHGEE6SxnD8gAAAABJRU5ErkJggg==>

[image13]: <data:image/png;base64,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>

[image14]: <data:image/png;base64,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>

[image15]: <data:image/png;base64,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>

[image16]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEwAAAAYCAYAAABQiBvKAAAC8UlEQVR4Xu2Xz6tNURzF30uUDIh049wf7o/y4xblJopiyMBA0nsTlFAMDJgZEEVJFFNk8AbmlJhKmSjl/QFvZvx6E/Umz1rP3rdt3X323veeQ+J86gzuWt/v2j/u+Tk1VVHxx2m1Wsuq/S9g7SuqBUHDNxxXVXfZARhsj3q9vjnLsi2QX2ttDDfHdyBzVnsmod1u70XegpM9j2O/1jUajS591b2g+AAmOKO6ixnslKs1m8331DudzkZXHwe7kFQ9FcztDPuxYfvUM9lvVMceHIM+p/oIsYlh8MuoeaE6ifXGMJMfycbkjxvvgnox0LuJvZj3NfUIrowefd8fHV0PCh7GikI+zzLVUkHuDWb3+/116iH3Nj0s/oF6IXi1mI3erZ6LqRlZl9GXVB9iCr6rboG3zdScVo9gYQPVUuG4vkkTZ0Fr1Avh9AXJq8Mf9MSnD6GJRZ9U3cWGm9pb3W63oTWTYPJeqk7MeF9UD4HFHjR9r9RT7HpUr9VqG3z6EJq8plV34RPLDmAPaF+1bhzspYMN2+Pq0G6a/POungL6Fk3vLvUUuw7VSZ6+ijGnVc8DC3znbpz6qaB3qUi/j9Q5oeYt67CWS+qRYEbQDJA6uTyK9vtIzYzVhbxVk49h1Qm8R6pZYoPGKNrvIyWz9fMFfWUwGKxVzxLMoKn3EUuo0UzuseqpmP551YuQuGGsCX4CBjNMwD3VwTQ9bOZhNaCdhfdJdZIyaZzRd1iDG/929UKkZNNH/gfV+SCg53vzd0Hd0eAYeZNA44z1cDx19OB7Sl4egf7MyRweWpeHrcccDqlngf+RNfw2tBr+4HOm74pb6wN1c8E5cXBfAbSL8vtE3lNFQe1n1coC2Xf5Qa26gpqdWNts3u0mD+4FvzJU/wXfhhWh7DyX35lNUvN5v1pQcRKQs4wX4fWqlwE/lmMv2UXAmXU/y7K66l6w0EU0HFF9XJBzXbWyQPZz1cqi1+ttTT27hqTeo/5F+I2sWkVFxV/LDzneHOv20r8CAAAAAElFTkSuQmCC>

[image17]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAAAYCAYAAABKtPtEAAACmUlEQVR4Xu2Xu4tTURDGsw8V8VXFqCS5eUGKIChpBEUEGwvtFGEXBAsrwUbRQlCwFfaPEHYba0H/AkULKwWrNLKVhSzY2KzfZO9c5nyec/fcJHur+4NDzvlmzpyZyX0ktVpFRS1JkrcYu2a8yRlb5LvJ8Q4CnPODtRiwb6fb7Sas/8dgMDipRbHNUq/Xj8f4xWKbyTYFtm3WipAX22G/RITYBsD+XXza7fYztjHwexKKJ3qn07nLekGWQvEdYgqLbQAKv54mf4ZtDHwfhOKF9KJIHNwKQ9YdYgqLbUAR0KT7vnjQXqM591ifBcR54TvDIaawkhuwi2fTEdZnodlsDnxnOMQUFtsA9ZHiSH8uutwi/X7/NOY7GO988XyaAtsvjDVMV9N4L/H5CeuV0L6QnqFJs26JbYAgPp4GyL14lbQJx8O+C6wZVmG/pItkrxlT37zcRB+NRodZz8jbrMzTgNA+aK9Ylyc/awr0n7SWK+B2Ol9vtVrnrF0RP9wK51nPCCVoKasBKOgRawH0FbfEBibN5wbrGaEELWU1APuuseYDPhsxfoL45b4KQwla5mzAxLfP1wCsu6wpuIyPDofDEzL35YL1F7tWxK/X651iPcMXjJmnAarh8r5lpOVQPJ8mpP7fzDzzw3mfO4EfX6F4GRzMR2QDpq8iO9SA+WNZowk3pRGYf0zSK0CGfUrLutFoHNO11dPPh4hxR9eYX8F46nrvAZ+LNg8vJtlltimRDVgI8qpDQR9YnwXku43xl3UHU9gK25QyGyAs6hyJg2ZeZt1BCxuPx4fYppTdACT9HmdNWC8C9p+V/wKsO8jrQQtr5/yFTROa+uX+qlogOOs3a0XY98vSgnjM6ncQ4Jw/rMWAfV9Zq6ioyPgHZ3NDL//XxuMAAAAASUVORK5CYII=>

[image18]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACMAAAAWCAYAAABKbiVHAAABq0lEQVR4Xu2WvUrEQBSFY2UjiD9BzH9CRBBsRVGxEUGwENfKUrCzEAvxAay1sBHBd/AB9Bm0shHWQh9ABBFs9FydwOzJZJOgaxo/GJace+beM8mGXcv6548Iw7DNWhnY88FaB57nTcB0K0a17rHm2KeD+k0QBGesZ7iuO8KaEMfxJPa+sW75vr8ow2FY4ZoKdcW6gBBDqB2xjj4z0E+zQ3E9A7VV1r4GovEJ6wIaj0nddELor6wJ0J+xdtFzp1uYDnBHHBVkk2s6phPieos1plYY0xATJp9JYyqHSZJkUDV84BpjGizXURQd6hpTOQyMl6rhOtcYDpOmab9co8ea7mMqh+EBRcBzrrz7mYYhU6LJ66l7mV6EyflwN5dEcxxnVNeZXw2D+p14bNse0HU8Jlt0hJrVdaZOmKcyY7fAqtZiXadyGEE1fGQdPwuu1NBsgWsZau816zp1w1yoofOatqG0A93LyCGKBqmguYXHusfeHDDGWC3ckWmuFQHvcFGYRkCYF3z0sd4YCPTOWlWw95i1HxF+/+fZZr0M7BnvyWPGl32ZtTLKXpBG+ATGRpmEp5XeJwAAAABJRU5ErkJggg==>

[image19]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAYCAYAAAC8/X7cAAACR0lEQVR4Xu2WPUhbURiGU9Aq6NLWEEzuzQ/JFrBgpg6SSTJJJXOnzu3QpWMptNipoTo4ddJRdOtS6Nq5IA6F4hhEujvq+13OKV/efOf2kh8HzQOHm/u+3885J/fcJJebcceoVCrXrI3LSDVLpVKExJ+S7Ea/Wq12OE4D/0u5XH7EuqDqJMPw+6GYOI7rqN3W8UEwgZYr0GXP6X9YF6CfYPxmnfGTi6LoMXuCnrjG5R2yPoQLPGBdaDabD52/zp7ojUYjz7oGu7iNb/aJq3HGvgB9jzUBG7sVWlxCsVhccYVfsqdxMQOFcL+KcaE1C5+HhXyXz7hWtV+v12NcHmhNIzmyiawnWBOzsOJwf4wdeq01C5/XarXmXZ2+9lFjR98zWO8ucl6xnsvn88uu4CV7TGAB/124PAIYn/z9KHUKhcKSGQPxSAw0eMEeM0pjATG/8DYp+nv/GOlzk7HOcIw1KQs0feNiB94GWXKtGN0X1x7qP+cYxqqTeQEq7t9BQ9PFjLmnhvZZcmu12lqWGoIZl2UB8L9JjHtTsJeaK8gPI2uC752lhmDGQTw3DUVak5Dukfc/ax61gA/sWQR7uSJ/WZe/BuKlHXDx9QFlgk0BHp+nab4GG9FG7BXrCTD23UQ3vYaEjlvYRx3LwO8h762hS+7A4BghpDOIO8Sc3rM+AHYEcZWuHCz20sg6iXGYag8pLotnfVL4p4H1iYEzsDHNBlI79CabGGjyFZc51sdFfq1xxt6xPhWwiB9ouMD6qKDes1ub/Iz7yA2yqdCCDmyFDgAAAABJRU5ErkJggg==>

[image20]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABcAAAAYCAYAAAARfGZ1AAABCElEQVR4Xu2UvQ4BURSE9QrlJrL/kYhEg0Sl0AsSFBqlXu8BvIZHEK+g1xGVRO8JNMxJzm42g3UXlfiSm93MzJn9uZvN5f5kIQiCsud5O6yrrj1WnXOZ8H2/LWWu67bYiy7EujFavGBdsG27JL5lWXn2UnEcp6jFXfaSvHX3pkOmuZgwDAs6dGCPyVyOTVzrUIc9JnO56QD2YyU5HCdJHVoNe9ZLajGm5ZzD+TzSPiqHf9Lc5oGXWn42KJfiC+tCarmgw8cHeiAe3nODvYiX5RheSgj/lGak4Ssai4bjLJllNNNn/Q5cJMQa4U6q7D1Dn3rA+lfQ8iHrH4HCCp5yquVbOefMnx/iBuaIX682QzQKAAAAAElFTkSuQmCC>

[image21]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABcAAAAYCAYAAAARfGZ1AAABMUlEQVR4XmNgGAWkAEVFRXV5efmrQPwfiq8BsRG6OpKAgoKCA8gwOTk5G3Q5mEXo4kQDqMHt6OIgICMjowKSFxcX50aXwwtkZWWloAb7osshA7JcT6wmYtXBgZKSEj9U0w10OXRAsuHASNwE1eSNLocOSDacWA3A+NgAUgekY2Fi0Eh+CBTLQ1YLB8Qajq4OyA4CJV0QG2j4TiC/G64YBtA1YQMg10HVHUYSQ7fsv4qKCjuMDxN8Q4ThIIN+oYndBOJiZDVAihFJCUICiO9hEVcEyQG9bYwuhwyAwZMJVLcUXRwMgJoXgAwBlilmMDGghgiQGJAuQFaLDRDyORgALVEC4hBgjtVBl8MFgAZPBtFAR3AYGxuzosuTDUCpBMYGGp6AJEUZgMYTCkZXMwqGEQAAN4plBarQFAIAAAAASUVORK5CYII=>

[image22]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFwAAAAeCAYAAAChf3k/AAADZUlEQVR4Xu1ZO4gUQRDdkwM/CCq4wg2727N7K4omBioGggf+UFHUQOEUM0FEDzERDDQR1ERBMDDWSMFDQdDIQDA6TsFEQQTxMDAwMBFMzvfWKmhr+ub2A7OznwdNV72q6emq7umZrS0U+hxxHK9Gm7C8hXPuoeXaQbFYXIn7PbD8wACJvIE2b3kfsJ+ynAK2MSTwNseoVConrD0E+ltuoLBIwkdg/2VJPhmh60JcCPB7YrmBQVqSYLuDnXsxwM+Xy+UoxMN/j+Ut0u6Zd3AHfsWOe4Z+mgQCviuB70b/gXKpVFoPfRPkFzZY6rj+HPpPIk/4Ns9VuS9oxy1P0B/tqeUtZH5rLJ97cOJRFK2ljACuoRtR3k8WZezIbSJPIqmxb0O3xOgJOY1TSCJPW96CfpjCFsvnHppYbQj2ivII6JLvpzL4XWj7QzbRZ3URrQ3jH7acol6vF31btVrdjrbB91HAb8alvIwT4PnlB2rtWWGhe8u8zvu6ykjaTugHQzbR33pPw3+28fHxdZZTgP/DxaRcq9Uq7FMS3tRZn4AE9t7yWYH3R5AbPf2Q8ghoyvdTmWc0d2rIZnXK2LlLjf2NPX8lD5d9jkhLeEGOv5YgNwq+QLIAAnIyhwNoM+TkZUnuO9RR6Gepo7/JuSLhj9F/RJukv/jO8kwV+YKOD/kRrjujusc3jiz0VyljR6+yPsQiCW8N3CltXdhj6CRGfhlZjsCYxyy3KHDR604m0ytwHfysx6bcEeBOWi4BfMcuZ3KxYpupy6PHx+qo9e1HINYflmsHOGL24YW81fIJSII/q45EP29md8NnThenmYYFfWnHGDjw25bJ8Dno05bLEnaher2FgnsX4LqW8L4FkjrGxOKDv2x4Jvybz/Ui4rzVw92/79vETpaEN75jMcAta1e4nJ/hLof1cFbj7PndqMBRxk1eYYBlvr3XYOMzyL4eDuM9JPa6yD/R7nPgKIpWoP9t/XsNaUlyw3p4AsN6eJbgxIf18AyhidXG3wzKx12sh8NvrxTW5lgXt76u1Xp4XrBQ8LIAXauH00fKuqMhf3LNnPW5Ayce57gejoU74gL/F8g9Wq+Hdxt5r4fTZjliIX6IQvvJcVIO4YIHbK3XwwcFro2f9U4+P7X5triZevigw2VdDx8iG/wFLBruCVfTpWAAAAAASUVORK5CYII=>

[image23]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABcAAAAYCAYAAAARfGZ1AAABSElEQVR4Xu2Uv0rDUBTGK3Sr4BQCkv8RpKWTopOIuzjVQSj1GfoMXbq1Q4dCJx9BfAXfQFCcCm4OPoGLfkfOjdePi9xEcOoPDrn5zne+9CZNWq0NdcjzfD9N00fUh9YT6oB9tciy7EzCkiQ54Z65EOveaPCUdSGKoj3ph2HY4d6vxHG8q8EX3LNp9Ot9h3x9FUVR7OjQM/eY2uF4iHc6dM49pna47wCex634cBxZWg/aK2pieyt8w9mHd+EU5wNZ4yLXqOW3W+EhF+i/qO/eaLidD9Zc25kB8c3ZsNDgd9YNsgPUgvUvdHjt0HPpYcuH3DPo7Ir1CgzfiAn38dho2PaVaDiOba8L+IbImLP+AxgK1CXe2D73GHiOcGibc91B17I0R8OqZyXrsixj29MYhM3kIxcEwTbWa/k7suevbEmofP+5seH/+QRzDWUU8inOewAAAABJRU5ErkJggg==>

[image24]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABcAAAAYCAYAAAARfGZ1AAABFklEQVR4Xu2UvYrCUBCFxdbCMiD5R7CxUrCy2H6RbSxsLK3X0jfwNXwEtdbKRuxdrITtfQKb9UyYK/Fgws1qJX4wueGcmZN7E7RUelOEKIoaQRDsUX9aP6gW9xUiDMMPCfN9v8ueeRDr1mjwlHXBdd26+I7jVNjLxfO8mgb32Evzr93bDtn2XYnjuKpDB/aYwuH4iEsd+mSPKRxuO4DvMZc+rMM73jdrCbbheX1Zeu6QAf6v9m3Yw2vdQd+yngDjZBEuwWfWQVkumeGCDh/v6JF4eKdt9gR4a12zwzE8kxD8p3SMhuMORMM6Tvca4K1S99nhBjwkRvXxi22yx+hpbwobWXDfw0gwa08BJx3prieoL/bfvAgXlM1gijAS6IwAAAAASUVORK5CYII=>

[image25]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAYCAYAAADDLGwtAAAApklEQVR4XmNgGHxAVlZWSl5e/j8Mo8tjAKjCC+jiGACqMAhdHAUoKCg4EGvtfgyFMjIynCBBOTk5bagisCeApgagKIRK3IHxgQo2YZgGNKUcXRDIX48uBjPtPBYxhEIgRxIkoKysLIukDqbwMbKAJ4YVEHGQwigQG+jeDhDNiK4QyL8MEwO6fydQIQdMYhJQoB7KfgfEU0EKpaSkuID0dyQzRgGFAABbmjhuxRY4PgAAAABJRU5ErkJggg==>

[image26]: <data:image/png;base64,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>