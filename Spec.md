# Semantic Streams Augmentation

2026 Sebastián Samaruga. [https://sebxama.blogspot.com](https://sebxama.blogspot.com) 

This work is licensed under a [Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License](https://creativecommons.org/licenses/by-nc-sa/4.0/).

# Summary:

This document describes a semantic RDF based data integration and intelligence framework by means of Aggregation, Alignment and Activation of ontologies.

# Base Model

class Resource    
\+ ID : URI  
\+ primeID : BigInteger  
\+ occurrences : Occurrence\[\]  
\+ apply(res: Resource\[\]) : Resource\[\]

class Occurrence extends Resource    
\+ player : Resource  
\+ context : Resource    
\+ role : Resource (Kind?)

class Statement extends Resource  
\+ context : Context  
\+ subject : Subject  
\+ predicate : Predicate  
\+ object : Object

class Context extends Occurrence  
\+ role : ContextKind

class Subject extends Occurrence  
\+ role : SubjectKind

class Predicate extends Occurrence  
\+ role : PredicateKind

class Object extends Occurrence  
\+ role : ObjectKind

interface Kind\<PlayerType extends Occurrence,  
          AttributeType extends Occurrence,  
          ValueType extends Occurrence\>

class ContextKind extends Context implements Kind\<Context, Subject, Object\>

class SubjectKind extends Subject implements Kind\<Subject, Predicate, Object\>

class PredicateKind extends Predicate implements Kind\<Predicate, Subject, Object\>

class ObjectKind extends Object implements Kind\<Object, Predicate, Subject\>

## Resources

Everything is a Resource identified by an URI, assigned a Prime Number ID, keeping track of its Occurrences and thus enabling the calculation of their CPPE (Prime Number Contextual Embedding) by means of the product of its Prime Number ID by the Prime NUmber IDs of the other Resources in their co-Occurrences.

## Occurrences

Participation of a Resource in an Occurrence in a given Role (Kind) in a given Context (Statement, Kind).

### Statement Occurrences

Statements are Resources whose occurrences are their CSPOs in a given Role (Kind?)

### CSPO Occurrences

Context, Subject, Predicate, Object as Resource(s). SPO occurring Statement Contexts where they are in C, S, P, O Roles.

CSPOs instances as wrapped arbitrary Resource Occurrence Context

### Kinds Occurrences

As Context, Subject, Predicate, Object. Occurrences: Kind Functional Definition Statement Contexts (occurring Statement Contexts)

Kinds as Resources: Kinds occurring in Statements in C, S, P, O Roles

## Statements

Context, Subject, Predicate and Object (CSPO) tuples.

Context, Subject, Predicate, Object (CSPO) Statement Occurrences have a role (Kind) in their given Statement Occurrence Context.

Kinds: ContextKind, SubjectKind, PredicateKind, ObjectKind (CK, SK, PK, OK) are themselves CSPOs respectively and can participate in a Statement Context as Occurrences. Types of Statements:

* SPO Statements  
* SPO / Kinds Statements (recursive Kinds)  
* Kinds only Statements (recursive Kinds)

This is further leveraged in the Augmentation Layers Domain Model definitions section.

## Contexts, Subjects, Predicates, Objects

The role of a Resource Occurrence in a Statement is typed by its Statement Occurrence position. A Resource can occur in more than one role or occurrence type (CSPO) in different Statements. The type of the role (Kind) of the Resource Occurrence is determined by the type of the position it plays in a given Statement.

## Context, Subject, Predicate, Object Kinds

Aggregation of PlayerType(s) Resource Occurrences (SPOs) by common AttributeType(s) and then by common ValueTypes(s). Parameterized interface for each Kind type (CK, SK, PK, OK).

Kinds can be aggregated from raw CSPO Occurrences from any combination of C, S, P, O / CK, SK, PK, OK Statement Occurrence types. This allows for recursive Kinds definitions (folding). This is further leveraged in the Augmentation Layers Domain Model definitions section.

Kinds are a kind of “type inference”: if a Subject shares common attributes with another Subject, it is of the same Kind “type”. If their common attributes share common values, it is of the same Kind “state”.

Root Kinds are the Kinds corresponding to the CSPO Occurrences Statements positions. They have no attributes nor values, they just tag an Occurrence as being of an CSPO Occurrence position in a Statement.

Kinds hierarchies: basic inheritance, if a Subject attribute set is the superset of another Subject attribute set, it can be regarded as an “extension” of the first Subject. Leverage this with other inference mechanisms (FCA, for example).

Kinds ordering: a Subject “extended” by another Subject attributes set can be regarded as being “before” the first Subject. This assumes the existence of a super type is necessary for the existence of a sub type.

Kinds are represented and serialized by Statements whose Statement Contexts are the Kind instance itself (Kind reified Context Resource Occurrence), and their Subjects, Predicates and Objects plays the PlayerType, AttributeType and ValueType of the Kind definition. Thus, the definition of a Kind is the set of Statements of its corresponding Kind as Resource Occurrence of their Statement Contexts.

### Kinds as Extensional Functional Definitions

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

# Base Model Representations

Base Model class hierarchy is represented by different meta model approaches (kept in sync with each other) for leveraging the most appropriate inference mechanisms.

Models persistence Monadic wrapper bound Base Model Entities (Resource, Occurrence, Statement, Context, Subject, Predicate, Object, Kind, ContextKind, SubjectKind, PredicateKind, ObjectKind) Functional APIs Definitions for stream processing.

## RDF Model Representation

Raw RDF Statements Triple (Quad) Store. SPARQL Endpoint.

## Sets Based Model Representation

Contexts Set (Subjects Set, Predicates Set and Objects Set union).

Subjects Set.

Predicates Set.

Objects Set.

Context Kinds Set (Subject Kinds Set, Predicate Kinds Set, Object Kinds Set union).

Subject Kinds Set (Predicates Set intersection with Objects Set).  
      
Predicate Kinds Set (Subjects Set intersection with Objects Set).  
      
Object Kinds Set (Subjects Set intersection with Predicates Set).

## ISO TMRM Model Representation

Underlying common metamodel (TODO).

## FCA Context Lattices Model Representation

Context, Subject, Predicate, Object as Context Formal Contexts (TODO).

## XML Model Representation

TreeGraph for nested Statements structures Stream Processing. Pipeline messages format. See “Messaging Infrastructure".

# Execution Model: Augmentation Agents Pipeline 

A sequential message driven execution model, the Augmentation Pipeline, performs, by means of message exchange streams processing (unfolding, merging and folding), the Semantic Streams Augmentation of raw RDF CSPO URIs Quads input Statements (from configurable Datasources\*) into executable models of knowledge gathered by means of (1) Aggregation, (2) Alignment and (3) Activation of Statements (messages) encoding corresponding layers domain models Statement types structures.  

Augmentation Agents communicate with each other by means of a series of messaging endpoints where each layer consumes its input (source) Statements and publishes their output (production) Statements. Layers input and output Statements are of two types: an Augmentation Agent layer can consume both of their source Statements types and their production Statements types.

In the first case, processing a source Statement type input, it “merges” this input source type Statement with its source level type already known processed Statements aggregating, aligning and activating possible new inferred Statements. It then “folds” (aggregates) the resulting merged Statements into its layer corresponding Kind types Statements, then builds and produces its output production (Kinds) Statement types for production publishing.

In the case of a layer’s production Statement type as the consumed input, agents merges this input with its already known production statement types (matching / merging input Statement Kinds with already known Kinds), it then “unfolds” input Statement components (Kinds) into layer’s Kinds aggregated originating source type Statements obtaining this way the source Statement type Statements which originated the input (Kinds) production Statement message (source Statements). It then performs, with each “unfolded” Statement, the same way as if it were like those source Statements where consumed source Statements (merging, folding and publishing). Intermediate source type merged new inferred Statements are also merged, folded and published.

This Agent pipeline execution model could be depicted as:

source statements input / merge \-\> folding \-\> production statements merge and publishing

production statements input / merge \-\> unfold \-\> source statements merge and publishing

The merge steps in the pipeline is where new knowledge (Statements) are Aggregated, Aligned and Activated, where pipeline layers inference is performed materializing inferred knowledge into new Statements of each type. That is why it makes sense to merge new inputs with previous knowledge and inferred knowledge in a pipeline in / out fashion.

This fan in / fan out approach is intended to be implemented in a reactive functional streams pipeline where each agent consumes and produces knowledge asynchronously and in parallel. An Agent production type Statement is another Agent source type Statement (maybe including the Agent itself) and an Agent source type Statement is the type of another Agent production Statement type. An Agent “accepts” an Statement (source or production) if it is not known already or if it was further processed (updated) its context since the last consumption (or “acceptance” performance is no-op).

## Homoiconic (code as data) approach

Messaging pipeline oriented resources consumption and publishing. Merge, Fold, Unfold phases functional approach.

Merging input data against previously known data, applying previously known data as a Template / Alignment / Transformation for merge over input data is what is meant with “code as data”.

Resources (Occurrences, Statements, Contexts, Subjects, Predicates, Objects and their corresponding Kinds) are “functional” entities that can be “applied” to another Resources. The signature of such functional composition is as follows:

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

## Messaging Infrastructure

Messaging pipeline:

aggregationSourceTopic \<-\> Aggregation \<-\> aggregationProductionTopic

aggregationProductionTopic \<-\> Alignment \<-\> alignmentProductionTopic

alignmentProductionTopic \<-\> Activation \<-\> activationProductionTopic

### Messaging Format: TreeGraph

All Base Model entities Statements of each layer type must encode all of their corresponding composing entities in a single message. A Statement containing a specific Kind must encode all its Kind’s composing aggregation Statements, for example. 

Source, Production Messages includes all Statements hierarchy which compose / lead to produced Statements (TreeGraph). Serialization. References to Resources (Registry Helper Service) to reduce message payload size..

## Datasources

Raw RDF CSPO URIs Quad Statement Messages Endpoint. Configured to produce configured datasource data and to consume updated Statements synchronizing state. 

## Stream-Oriented Merge, Fold and Unfold of Layered Statements

As Resource functional composition (Homoiconic approach).

Layers inputs / outputs. Layers functional definitions. Rules from source 'terminals' to production 'non-terminals': produce all possible production source Statements given contexts / constraints. Inferences.

TODO

### Fold and Unfold as the Stream Context Resolution Operation

TODO

### Merge as the Central Stream Contexts Operation

Inferred new Statements by Augmentation pipeline phase.  
TODO

### Possible Merge Approaches

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

#### RDF Merge

This approach relies on graph theory. It essentially performs a graph union of multiple RDF datasets. A critical function of an RDF merge is the standardization and renaming of "blank nodes" (anonymous resources) across different graphs to avoid collisions, resulting in a single, unified knowledge graph of subject-predicate-object triples.

Merge Statements as RDF graph patterns, combining compatible subjects, predicates, and objects while preserving graph identity and provenance. This provides a straightforward representation for stream-level graph merging and interoperability with RDF-based tooling.

#### TMRM Merge

TMRM merging is driven strictly by subject identity. If two topics (entities) across different data streams share the same subject locator, subject identifier, or item identifier, they are deterministically merged into a single topic. The resulting merged topic accumulates all the names, occurrences, and associations of the original topics.

Perform merging at the TMRM metamodel level, using Resources, Occurrences, Statements, Subjects, Predicates, Objects, and Kinds as the semantic structures being matched and consolidated. This provides the underlying subject-centric merge and identity model for the pipeline.

#### FCA Merge

This approach merges data at the conceptual level by combining "formal contexts" (mappings of objects to their attributes). When two concept lattices are merged, the FCA algorithm recalculates the matrix to build a new, unified lattice. This is highly effective for discovering new structural hierarchies and implicit relationships that weren't visible in the isolated data streams.

Treat matching Statements as formal contexts and merge compatible contexts to derive shared Properties and higher-level relationships. This is particularly suited to the Aggregation phase, where input Statements are consolidated into Property Statements. 

#### CPPE Based FCA / Model Primitives Merge

Operating at the most atomic level of a data architecture, this approach aligns the fundamental structural primitives (e.g., core entities, base properties, and semantic rules) of the models. By merging the structural primitives *first*, the pipeline creates a standardized baseline context, which is then fed into an FCA merge to build highly accurate, normalized concept lattices.

Combine FCA context merging with CPPE/model primitives to support higher-level semantic matching and inference. This approach can be used in the Alignment phase to derive ontology matches, links, dimensions, ordering, and related Rule Statements. 

#### Sets Model Based Merge

Rooted in classic set theory, this methodology uses strict mathematical operations (unions, intersections, and relative differences) to combine data. It treats data streams as collections of elements, making it an incredibly fast, deterministic, and highly scalable approach for deduplication and exact-match aggregations.

Represent Statement components and their relationships as sets and apply set operations such as union, intersection, difference, and compatibility matching. This provides a simple compositional mechanism that can be used as a lower-level merge primitive within the other approaches.

#### Integration into Streams Processing

TODO

## Streaming Agents Augmentation Pipeline

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

### Aggregation Service Agent

Context / Role / Type inference in the Aggregation Layer.

#### Aggregation Agent Domain Model

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

#### Aggregation Agent Merge / Fold / Unfold

See Homoiconic approach. TODO

### Alignment Service Agent

Ontology Matching / Links / Attributes / Dimensional / Order inference in the Alignment Layer.

#### Alignment Agent Domain Model

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

#### Alignment Agent Merge / Fold / Unfold

See Homoiconic approach. TODO

### Activation Service Agent

Contexts (Use Cases) and behaviors (Interactions) in the Activation Layer.

#### Activation Agent Domain Model

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

#### Activation Agent Merge / Fold / Unfold

See Homoiconic approach. TODO

### Helper Services

Monadic wrapper bound Base Model Entities (Resource, Occurrence, Statement, Context, Subject, Predicate, Object, Kind, ContextKind, SubjectKind, PredicateKind, ObjectKind) Functional APIs Definitions for stream processing.

“Leverage X” Sections Functional APIs.

Kinds as Extensional Function Definitions Functional APIs.

Resource merge / “application” (transform / template) Functional APIs.

#### Registry Service

Registry API Functional Definitions.

#### Naming Service

Naming API Functional Definitions.

#### Index Service

Index API Functional Definitions.

## Dynamic API Endpoints

HAL like or discoverable behavior APIs over Activation activated knowledge statements. Render interfaces for contexts interactions instances. Message driven API rendering Contexts Interactions (DCI) behaviors (state) and role executions (verbs).

# Leverage TMRM

Underlying graph metamodel.

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

# Leverage Dimensional Features

Statement Predicates are the Type or Instance of an Action / Verb

:name instanceOf :naming

The Power Set of every attribute contains the sets of attributes of every possible class / concept. Includes relation defines an ordering over the power set. Power Sets (CSPO / Reified Types Sets). All possible Subjects, Predicate, Objects, Kinds Grouped Types. Order Relationship (Includes). CSPO Sets Intersection: All possible Statements. Grammar (production from possible rules).

Order and hierarchies are defined by subset / superset relationships. An object having attributes who are a superset of another object attributes is “extending” or “after” this object.  
Dimensional (Contexts) Features

Kinds, type / state hierarchy / order inference and materialization into Statements. 

Alignment. Order (axis arrangements). State transitions flow. Infer and encode types / instances state transition networks on a given context on a given event: 

* PCN (Previous, Current, Next) in axis / scope Graph Traversal Node Types: Individuals, States (occurrences role types), Associations (events). Order Hierarchies. Contexts:  
  * (Single, Marriage, Married);  
  * (Marriage, Divorce, Marriage);  
  * (Single, Married, Divorced);  
  * (Junior, Promotion, Semisenior);  
  * (Junior, Semisenior, Senior);  
  * (Unemployed, Employment, Employee);  
  * (Unemployed, Employed, Unemployed);  
  * (John, successor, Peter);

Leveraging Grammars as an LLM Interaction tool

Possible contexts / functional transitions (behavior) as formal grammars rules / productions.  
Possible Prompts in context. Contexts Roles behaviors Flows. Inference context productions from grammars. Statements as grammars rules / productions.

# Leverage RDF

TODO

# Leverage Sets Model

TODO

# Leverage FCA

Formal Concept Analysis for classification, types and attributes inference.

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

## FCA-based Relational Schema Inference:

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

# Leverage CPPE

Algebraic inference by means of numerical prime numbers IDs embeddings.

## Algebraic Semantic Embeddings (CPPE):

### Prime Numbers Identifiers:

Every Resource is assigned a unique Prime Number ID (sequence) associated with its URI (via Registry Helper Service API).

### Prime ID Embeddings:

Each Resource is assigned an unique incremental Prime Number Identifier.

For a given Resource occurrence in a given Statement context its Prime ID Embedding is calculated as the product of this occurrence Resource Prime ID Embedding with the Prime ID Embeddings of the other two parts of the Statement occurrences.

For example: given an object occurrences its Prime ID Embedding is the product of its Prime ID (Embedding) by the Prime ID (Embedding) of the other occurrences components.

Augmentation Layers. Stream Pipelines:  
Aggregation, Alignment, Activation steps. Leverage Prime ID Embeddings for reactive functional composition.

### CPPE. FCA-based Embeddings: A Deterministic Approach:

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

#### 

#### Relational Context Vectors

The core of this approach is the Relational Context Vector (RCV). For any given statement (a reified triple), we compute a vector of three BigInteger values, (S, P, O). Each component is a CPPE calculated from one of the three FCA context perspectives, providing a holistic numerical signature of the statement's role in the graph.

* **RCV Definition:** RCV(statement) \= (S, P, O)  
  * **S (Subject Context Embedding):** The CPPE of the statement's subject from the Subject-as-Context perspective. This number encodes everything the subject does. S \= calculateCPPE(statement.subject, SubjectAsContext)  
  * **P (Predicate Context Embedding):** The CPPE of the statement's predicate from the Predicate-as-Context perspective. This number encodes every subject-object pair the predicate connects. P \= calculateCPPE(statement.predicate, PredicateAsContext)  
  * **O (Object Context Embedding):** The CPPE of the statement's object from the Object-as-Context perspective. This number encodes everything that happens to the object. O \= calculateCPPE(statement.object, ObjectAsContext)  
* **Implementation:** A Java record RCV(BigInteger s, BigInteger p, BigInteger o). The Index Service is responsible for calculating and caching the RCV for every reified statement in the graph.

### 

#### Schema Archetypes:

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

#### Subsumption:

**Subsumption / Instance Checking (rdf:type):**

* **Concept:** An instance belongs to a schema if the instance's RCV "divides into" the schema's RCV.  
* **Algorithm: isInstanceOf(instanceRCV, schemaRCV)**  
  1. Perform a component-wise modulo operation.  
  2. boolean isS \= schemaRCV.s.mod(instanceRCV.s).equals(BigInteger.ZERO);  
  3. boolean isP \= schemaRCV.p.mod(instanceRCV.p).equals(BigInteger.ZERO);  
  4. boolean isO \= schemaRCV.o.mod(instanceRCV.o).equals(BigInteger.ZERO);  
  5. Return isS && isP && isO.  
* **Use Case:** This is a high-speed, purely numerical method for checking type constraints, which can be performed in memory without a complex graph query.

#### Property Chains

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

#### Querying and Traversal by Numerical Properties:

* **Find by Relational Role:** "Find all entities that have acted as a :Developer".  
  * The query becomes: "Find all statements whose instanceRCV.s component divides RCV\_dev\_schema.s."  
* **Traversal by Numerical Similarity:**  
  * Start at stmt\_A with RCV\_A.  
  * The next step: "Find stmt\_B whose RCV\_B has the highest GCD with RCV\_A."  
  * Allows traversal based on numerically similar relational contexts.

#### Graph Pipeline Specification: CPPE Algebra for Pipeline Stream Actions:

The **Contextual Prime Product Embedding (CPPE)** algebra treats every node in the graph not as a string or a pointer, but as a unique prime number. By leveraging the **Fundamental Theorem of Arithmetic**, relationships and sets are represented as products. This allows the Reactive Stream Pipeline to perform complex graph "joins" and "path traversals" using simple CPU-native arithmetic.

#### 1\. Algebraic Definitions

Let ![][image1] be the set of unique Prime IDs assigned to Resource URIs.

For any ContextPoint ![][image2]:

* ![][image3] (The singleton identity).  
* ![][image4] (The cumulative embedding).

### 

#### The Prime Product Rule:

The embedding of a triadic occurrence ![][image5]—where ![][image6] is Context, ![][image7] is Object, and ![][image8] is Attribute—is defined as the product of their respective recursive embeddings:

![][image9]

Because every factor is a prime (or a product of primes), the result is a unique "coordinate" in the integer space that encodes the entire lineage of the relationship.

#### 2\. Pipeline Stream Operators (The CPPE Monad)

In a reactive stream (e.g., Flux\<FCAContextPoint\>), the following algebraic operators are used for "Stream Action":

###### *A. The "Contains" Operator (Sub-graph Filtering):*

To check if a stream of Objects belongs to a certain Context ![][image10] or possesses an Attribute ![][image11]:

* **Logic**: ![][image12]  
* **Reactive Implementation**:  
  // Filter objects that are part of the 'Accounting' context  
  objectStream.filter(obj \-\> obj.getPrimeIDEmbedding().remainder(accountingID).equals(BigInteger.ZERO));

###### *B. The "Intersection" Operator (Aggregation):*

To find commonalities between two streams (finding the "Type" or "Concept"):

* **Logic**: ![][image13]  
* **Stream Action**: The Greatest Common Divisor (GCD) of the embeddings of two nodes represents their shared FCA attributes/contexts.  
* **Aggregation Use Case**: When the stream encounters multiple SPO triples, it calculates the "running GCD" of the attributes to infer the Schema (the most specific common super-type).

### 

###### *C. The "Axis Shift" Operator (Alignment):*

Alignment predicts a value for a new context by calculating the "Ratio" of change between existing embeddings.

* **Logic**: ![][image14]  
* **Stream Action**: By dividing by the "Old Axis" prime and multiplying by the "New Axis" prime, we re-project the object into a new coordinate.

#### 3\. Pipeline Stages Revisited via CPPE:

###### *3.1 Aggregation (Algebraic Type Inference):*

The Aggregation pipeline consumes raw SPO streams and produces **"Type Tensors"**.

1. **Input**: Stream of rotated triples ![][image15].  
2. **Action**: For all ![][image2] sharing attribute ![][image8], calculate the product ![][image16].  
3. **Inference**: If ![][image4] is divisible by the product of a set of attribute primes, ![][image2] is classified into that Type.  
4. **Complexity**: ![][image17] lookup via modulo instead of ![][image18] graph search.

### 

###### *3.2 Alignment (Vector/Prime Space Prediction):*

Alignment uses the **Prime Ratio** to detect structural similarity.

1. **Input**: Aggregated Types.  
2. **Action**: Map the distance between objects ![][image19] and ![][image20] as ![][image21].  
3. **Discovery**: If ![][image22] and ![][image23] share the same ratio ![][image24], the system aligns them as being "analogous" in different contexts (e.g., "CEO is to Company A what Principal is to School B").

### 

###### *3.3 Activation (State Transition Product):*

Activation is the "Activation Energy" required to move from one prime state to another.

* **Transition Formula**: ![][image25]  
* **Monadic Wrap**: The Occurrence Monad captures the prime state of an actor. When the stream processes a "Role" event, it multiplies the actor's prime ID by the role's prime ID.  
* **Trigger**: If the resulting product matches a known "Success Pattern" (a pre-calculated product of requirements), the **Activation** is fired (e.g., triggering a webhook or a UI change).

# Leverage W3C DIDs (Distributed Resource Identifiers)

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

### **The resulting principle**

I would therefore define the architecture as:

> **DIDs identify distributed domain services and advertise their semantic business capabilities. Domain APIs provide the invocation boundary for those capabilities. The semantic graph provides the shared representation of the domain entities and their state. Aggregation, Alignment and Activation determine how a requested business interaction maps onto that semantic graph, while deterministic semantic primitives perform the resulting state changes.**

This is arguably a better match for the document than a purely resource-oriented DID API because the document ultimately aims at **contexts, interactions and executable behaviors**, not merely distributed CRUD over resources.

# Appendix: ChatGPT Conversation

## The key insight: behavior as inferred graph structure

Traditional ontology systems stop at:

Customer  
   owns  
      Order

Traditional applications add behavior manually:

customer.placeOrder()

Your proposal introduces a missing layer:

Customer  
   asks\_for  
      Product

Product  
   available\_in  
      Inventory

Inventory  
   managed\_by  
      Store

From which the runtime infers:

PotentialContext:  
    Sale

and then:

ExecutableInteraction:  
    CreateOrder  
    ReserveInventory  
    GenerateInvoice

The behavior is not explicitly programmed.

It emerges from graph topology plus ontology definitions.

This is a profound shift.

---

## **DCI is surprisingly relevant**

Most modern developers have never worked with DCI (Data, Context, Interaction), but your description maps almost perfectly to it.

The classic DCI idea was:

### **Data**

Customer  
Product  
Order  
Inventory

### **Context**

SaleContext

### **Interaction**

Customer buys Product  
Inventory reserves Product  
Order records transaction

The revolutionary aspect of DCI was:

> Objects do not own behavior.

> Contexts own behavior.

Your proposal essentially generalizes DCI into graph semantics.

Instead of:

SaleContext.execute()

you have:

Graph Pattern  
    ↓  
Context Activation  
    ↓  
Interaction Instances  
---

## **Your pipeline resembles a semantic operating system**

The stages you describe look something like:

Raw Triple Stream  
        ↓  
Role Inference  
        ↓  
Type Inference  
        ↓  
Entity Resolution  
        ↓  
Context Discovery  
        ↓  
Interaction Discovery  
        ↓  
Execution Planning  
        ↓  
Runtime Activation

which is very different from:

Source Code  
        ↓  
Compiler  
        ↓  
Binary

The graph itself becomes the executable substrate.

---

## **The music store example is particularly interesting**

Suppose we have:

### **Music ontology**

Artist  
Album  
Track  
Genre

and:

### **Store ontology**

Product  
Inventory  
Supplier  
Order  
Customer

Current software engineering would create:

MusicStoreApplication

by writing code.

Your system would instead perform semantic composition.

The runtime discovers:

Album  
    subclassOf  
        Product  
Artist  
    actsAs  
        Supplier  
Track  
    digitalVariantOf  
        Product

which yields:

MusicStoreDomain

without a developer explicitly coding it.

The application emerges from ontology alignment.

---

## **The crucial missing concept: affordances**

I think your model needs one additional semantic layer.

The graph contains:

Customer  
Product  
Inventory

but what creates:

SaleContext

?

Not merely relationships.

What creates it is an affordance.

Something like:

Product  
    affords  
        Purchase  
Inventory  
    affords  
        Reservation  
Customer  
    affords  
        Ownership

The runtime reasons:

Purchase  
 \+ Reservation  
 \+ Ownership

 ⇒ SaleContext

This becomes similar to planning systems in AI.

---

## **AI becomes a graph completion engine**

In current architectures:

AI  
    →  
        generates code

In your architecture:

AI  
    →  
        completes graph

For example:

Given:

Artist  
Album  
Track  
Inventory  
Customer

The AI infers:

DigitalDownload  
License  
Recommendation  
Playlist  
Subscription

as missing concepts.

Humans approve or reject them.

The graph evolves.

---

## **The runtime could be deterministic**

This is the most important part.

Many people imagine AI-native systems as:

User  
   ↓  
LLM  
   ↓  
Magic

which is impossible to audit.

Your proposal keeps a deterministic core:

Inference Layer  
    ↓  
Graph  
    ↓  
Validation  
    ↓  
Executable Contexts

Once the graph is accepted:

Execution

is deterministic.

The AI is only involved in graph augmentation.

Not execution.

This is a critical distinction.

---

## **Why this may be more realistic now than in 2005**

The Semantic Web community largely assumed:

Humans  
    create ontologies  
Humans  
    maintain ontologies  
Humans  
    align ontologies

which turned out to be prohibitively expensive.

Today:

Humans  
    provide intent

AI  
    discovers mappings

AI  
    proposes contexts

AI  
    proposes interactions

Humans  
    approve

which is much more feasible.

---

## **The biggest unresolved challenge**

I don't think the hardest problem is execution.

I think it's **behavioral ontology design**.

We already have mature ways to represent:

Artist  
Album  
Customer  
Product

using semantic technologies.

What we lack is a universal ontology for:

Sell  
Reserve  
Purchase  
Deliver  
Authorize  
Approve  
Recommend  
Subscribe

In other words:

The Semantic Web standardized nouns.

Your runtime would require standardizing verbs.

Or more precisely:

> Standardizing context activation patterns and interaction semantics.

That is where DCI becomes valuable, because DCI is one of the few software models that treats interactions themselves as first-class entities.

---

My assessment is that if such a system were built successfully, the final artifact would not look like a programming language, a database, or an ontology. It would look more like an **executable semantic knowledge ecosystem**, where:

Intent  
    ↓  
Knowledge Graph  
    ↓  
Context Discovery  
    ↓  
Interaction Activation  
    ↓  
Deterministic Execution

and AI's role would be to continuously transform incomplete knowledge into executable knowledge while leaving the resulting execution model fully inspectable and auditable by humans. That is considerably closer to a "semantic operating system" than to a conventional software framework.

Now we're getting into territory that starts looking less like an application framework and more like a **computational semantics architecture**.

What I find interesting is that you're attempting to solve a problem that most semantic systems avoided:

> How do we represent behavior without escaping into procedural code?

Historically, semantic systems represented facts:

(Customer123, purchases, Album456)

and programming languages represented behavior:

purchase(customer, album)

Your proposal is trying to represent both as graph structures.

---

## **The key distinction you're introducing**

You are separating:

### **Behavioral schemas**

Equivalent to DCI Context definitions, protocols, use cases.

Verb:  
(  
    Purchase,  
    Customer.Available,  
    Purchase,  
    Product.InStock  
)

which means:

If

    Customer in Available state

and

    Product in InStock state

then

    Purchase interaction is possible

This is not an execution.

It is a possibility.

A semantic affordance.

---

### **Behavioral instances**

Actual occurrences.

Action:  
(  
    Purchase\#1234,  
    Customer:Bob,  
    Purchase,  
    Album:DarkSideOfTheMoon  
)

This is equivalent to:

Interaction instance

or

Event occurrence  
---

## **What I find elegant**

You're implicitly creating three levels.

### **Ontology level**

Customer  
Product  
Purchase

### **Context level**

PurchaseContext

requires

    Customer.Available  
    Product.InStock

### **Interaction level**

Bob purchased Album42

This is remarkably similar to:

OWL  
\+  
Planning Domain  
\+  
Execution Trace

but unified into a single graph representation.

---

## **RDF Quad contexts become important**

Traditional RDF triples:

S P O

cannot distinguish:

possible

from

actual

very well.

Quads introduce:

Context  
S  
P  
O

which means:

PurchaseContext

Bob  
purchases  
Album42

can exist separately from:

InventoryContext

Album42  
locatedIn  
Warehouse7

This is where your DCI influence becomes visible.

The Quad Context becomes analogous to a DCI Context.

---

## **The recursive verb definition is interesting**

You suggest something like:

Verb:  
(  
    Verb,  
    DomainActorTypeState,  
    Verb,  
    RangeActorTypeState  
)

which can recursively expand.

Example:

Purchase

expands into:

ReserveInventory  
CreateInvoice  
TransferOwnership  
ReduceStock

which further expands into:

SetAttribute  
AddLink  
RemoveLink  
TransformValue

Eventually reaching primitives.

---

This resembles a semantic version of:

Lambda Calculus

or

Microcode

for behavior.

Not unlike how CPUs reduce:

ADD

into lower-level operations.

You are proposing:

Sell

reduces into:

TransferOwnership

which reduces into:

RemoveLink  
AddLink

which are primitive semantic operations.

---

## **This solves an old Semantic Web problem**

The Semantic Web had excellent declarative knowledge representation.

It never found a satisfying answer for:

What happens?

after a fact becomes true.

Rule systems attempted this:

* SWRL  
* RuleML  
* production rules

but they always felt bolted on.

Your model instead treats behavior as ontology.

Not as an external rule engine.

---

## **Activation as graph pattern matching**

I think the runtime you imagine is roughly:

### **Stage 1**

Knowledge graph.

Bob  
type Customer

Album42  
type Product

Album42  
state InStock

### **Stage 2**

Verb discovery.

Purchase

requires

Customer.Available

Product.InStock

### **Stage 3**

Pattern matching.

Bob matches Customer.Available

Album42 matches Product.InStock

### **Stage 4**

Activation.

PurchaseAction\#987

is created.

---

This is essentially:

Graph  
    →  
Pattern Match  
    →  
Context Activation  
    →  
Interaction Instance

which is very elegant.

---

## **Primitive verbs as the semantic VM**

This is the part that I think is the most important.

Eventually every behavior must become deterministic.

Suppose the primitive operations are:

AssignAttribute  
RemoveAttribute  
CreateResource  
DeleteResource  
CreateLink  
RemoveLink  
TransformValue  
EmitEvent

Then:

Purchase

might compile to:

CreateLink(  
    Bob,  
    owns,  
    Album42  
)

RemoveLink(  
    Album42,  
    availableIn,  
    Inventory  
)

EmitEvent(  
    AlbumSold  
)

At this point the runtime becomes deterministic.

No AI involved.

Just graph transformations.

---

## **AI becomes an ontology synthesizer**

The AI's role shifts dramatically.

Not:

Generate code.

Instead:

Discover verbs.

Discover contexts.

Propose activations.

Suggest mappings.

Then humans review.

Then the semantic runtime executes.

---

## **What this starts resembling**

Strangely enough, your architecture is beginning to resemble a fusion of:

* RDF / OWL knowledge representation  
* DCI behavioral modeling  
* STRIPS / planning systems  
* Event sourcing  
* State machines  
* Workflow engines  
* WASM-like execution runtimes

all expressed through a common graph substrate.

---

## **The question I would investigate next**

The crucial research question becomes:

> Can every executable semantic behavior be reduced to a finite set of primitive graph transformation verbs?

If the answer is yes, then your runtime has something analogous to:

Machine Language

except the machine language is:

CreateNode  
DeleteNode  
CreateEdge  
DeleteEdge  
AssignValue  
TransformValue  
EmitEvent

and every higher-level Context, Verb, and Action ultimately compiles into those primitives.

If that reduction is possible, then what you're describing is no longer just an ontology system. It becomes a complete computational model where:

Knowledge  
    \+  
Behavior  
    \+  
Execution

are represented uniformly as graph structures, and application development becomes the iterative refinement of semantic models rather than the authoring of source code. That would be a fundamentally different software stack from the one we've been building since the 1970s.

[image1]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA8AAAAYCAYAAAAlBadpAAAAu0lEQVR4XmNgGAUMcnJydfLy8tuA+D8yVlBQOATEDujqwQCoqR1dAy6MohEkADRVAY2/CUkJXByKr4EFgIoy0E0D8YEuiUEWAwEZGRlOrLbDAFDCC6ckA8RgWVlZP3RxMABKLsWlGehKC1xyYIDPWVBbpdDF4QCbZqCNBSAxYDgIIotjAKjmWpghIKyiosKOrg4DABUqQm1lRJcjCKA2fUUXJwpANXujixMEQE3roE4mHcACB118FAwWAAAwo0uqR1jzbAAAAABJRU5ErkJggg==>

[image2]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAsAAAAZCAYAAADnstS2AAAAlElEQVR4XmNgGAV0BQoKChvl5eX/Q/FakBiUfR4op4GslklOTi4NxoFpgrLnwthwSTgHqBGq+DhMDmiyPZI8AgAlvUEKgDb5osthAKDCC2g24QbI7sUKQJKysrI6MDYQT0GWBzpJEMawgZoE8pgn1L1lIDltbW02DFugph0H4seKiopmID4wBHYB6Q8gDSiKRwHNAQCS1y9c2HnLkgAAAABJRU5ErkJggg==>

[image3]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFEAAAAYCAYAAACC2BGSAAADCklEQVR4Xu2XO4gUQRCGbyMRRFHcZN8vBUVMfJ2PQEMRBU1URDET5BJBxMjgArMLNFCQAzHSSFAQxMzEQC8VFMVEETE4TA7BRP9/7Rp7/+3endldTvTmg8Lpv6uqu2r6esepqZycnJw49Xr9lWppQNySav8dKPKnmc4Zbq6geloQ/061vwH2MVOr1Z77NdMajcazZrO5W/0ZcNg5XNU5n06ns3ZQExF/ulqtblM9C8i9iM0/UH25wNoHtHEx6wksl8sVisEOC8EEoFQqbQzpozCpPFlxtd2Rcd9eTIc91LlUDEi8BPus+iiwEJyIo6oPAzHnvAITg/5UfZVisbhG64rV2m63q7G5VMSCqeFPeafqI1IIrTEI+lcqldWqj4OrdVZ14urd1R3gHrtkjYHdEl//6NKe2HPITzUDi5Vc3ILddxxj7Ze8g9SfDMqnwPcbch1UfRxsz0mjPOzEq27NSprIUxVyjDQxenKgz8JmvHESH8nVhTru6O2qh0ADT6o2Llh/PrQ3nnbqwVPvCkqaGCswpNtb8zVDdRff/Y7kMxpwyp83nN8R1ZW0jc5KqE6cwOvU8JWyytcTOAmn2/5Yk8R0+yzwtRj0Y9NVV9x+rqiuwO+i7WmA9V1Tw2Ac1j/r5XirPn24oJGaiNPUUC1Eq9XanMaP0A9pz6uuTPouJHx5affZwzhNNF01giKn7eTB5yPstT+P8V5/bLgmTqseAr5zqo1DrMahaBNRwONQotgCIY34/q4xF2wOl3P5j2cvsXwh4Psdd2Nd9VFxe/6qehQ437dC/YIJTtAxp52AXYZ98P3Q9K1eHo7329jX7V/YPtgnjtHMR3ie7/X+DS9ui0sLPzuQ84bqWcG6W7KuzdOwCXdVDY8FbGS9/tpRQ9LjnOcYz4f4Xzzfx+ls4t2AfoaNwxrrOIbPNYy/DPpxcRf6TdWHgSbuQdyie2GJQb+nvjHgvwB7o/qygJexgRtWfRQmleefhKdAtazwF3lFN5GM2wDE/1BtxYH7bAca8V71NCDuhWo5OTlp+QVc50FH+6BfxgAAAABJRU5ErkJggg==>

[image4]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAD4AAAAYCAYAAACiNE5vAAACfklEQVR4Xu2WO2gUURSGJ4koxle1rOxr9iULrk2KVApaCSlDwNJGFLFRFLuglTaCIGIQ7Ewd0c7GxlaQkFoCNlapBBsb/f/NveudP2eWmd1ls+B+cJi5/3nce+bO3N0omjFjauh2u0fjOL6jehaQ90e1iVKv1z9wEc5eqX8A86MsvlqttkbJHxt5G3eLXlA9D3joV1BnU/WJkrPxOcT+VnEYDn3X8zTuFjun+jC4eX+qPjGGaHws4HV/MbCeW9iGu38D2xOft2+w+5VKpc1xrVb72Gw2a7hfL5VKiz7uX+VEjXewLRw8F3B9SK3RaBQlbtXK97icDs3V/IE13IVdtPKKxeIJS+8Bxwbsu2hs6lY4dtbwGvyXvB5o562JXFziu8VunKXebrePBXFvrXyCZq9GwYHnam4H92aeqWOhXTqMJ58opGOCnT5DDbt/PNQ1zmuwTyl6OM+ulU9Ul7wbuMwH7j6a1wON3/STW+bjdEwKhcJJ1UiaFmdr/MA8Flj3tSxxxIzj60wHd099IdaCuNOqkTQtztA4zwwrX9G8QZhx/L5ckRX1tVqtqr+3Jko7ONK0OEPjuH9u5RM86HOR+5nTPHewPugHB6TV8/9weMic9hrGa9DvBePERKTT6ZxSjaRpqvvDUbSmagTakqux5sY8fF8H/gM5BD1cTvP1gHPLFX4GW0fCTuCj3jf4bquGRTzC9YnqYY1o/x/ZL/ycLeP6khofno+R2AThQ8b1K9bw2Y85N2qWkhn7IGbTqjeVoJH3fAtVHwY2jXqPVZ9axrVL46ozMdxOXVc9D8h/Wi6XK6pPO0dG2S0c1IVR8g8dLP6LalnggafajBn/IX8B0bEOeBO4zfcAAAAASUVORK5CYII=>

[image5]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAAYCAYAAACmwZ5SAAACdElEQVR4Xu2XzWsTQRjGmxraKogtFMV8f0GgoZeCICJ4EaEUTyoeLQUPLejRglAQoQfpzXM9F7z5FxTUv8CDlxyCIJ6Ll0Iu8XmXd8zkycxksynitvnBkJ3n/ZzZ2V0yMzPlAlIul7uspQn032PNC5x/YeywniYKhcLlSqXyhvUhisXiLTg+ZT2N4Kb9xvjB+gBjHYX/nHw+XwiuB8aDoEMKwWn9LKeW9QhZLMYp62lGHk+Mj6xHyIJLpdJD1g2w74sPEizovIfdy7FfCMR8R/y7Vqs1h+s7SU4UenyhcdlarXYN1+1QHq9NDHi7NVgXUGRJ7I1GY17muK7KHGOPfX2o/0BxzDsYB7Y2CslhH1NXXhuvTQ0Z1uUuik1209ZxpzbteQjEH7oKQ3vv0n3o4j44NG8Or81ngN712eIi8digbw79NG5unLLH4lutVm/Yui742NZsxF6v16+zbppadOlxm3KBnPckHo9Lnm2a+y3rLnx9qH6TdYMrJkIM2MUVl+4NigFiN1zxqPVE9Vm2uXD1gU1cNRo2djuXy12x7QLH/EUT7jv0E1cQtK55q5tmUHCZ/QSNH3g/aMxrM8exK5o8tp8BtV6xTf2jTynbBNkAlx4RKHZJdHMksZO3MW/bx9/EoqmX/bA+sK2V9Q+JeePj977tI1+AQA8RYjMvT82xq/5Z/D4id6n1HPpX1iN0Id5io0DsOsYW6+MySQ/MyFwjHQIg9gtrSZikBxt5vOLkysCpw2IMMvLZYHFc5AiylhRZLD5hD1gfAo4nKHyX9RB4HJ6xlgTU/slaQrLo6ROLXs5yp/81zWbzKjbuiPUpU84pfwAWk8DTMK+EEQAAAABJRU5ErkJggg==>

[image6]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAgAAAAZCAYAAAAMhW+1AAAAcUlEQVR4XmNgGAUYQFxcnFteXv4/ED+E0ovhknJycqkgQRgfyF4N58vKykqBOAoKCgJICkAmQBQAGd+RdWMAqOomdHEwABrrgVe3kpKSGl4FIABUcBXoizQ0sZtAPAVZAOSOw0C8FcRWUVHhQ1I/4gEAHishD09kYlgAAAAASUVORK5CYII=>

[image7]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAkAAAAaCAYAAABl03YlAAAAh0lEQVR4XmNgGAVkAUVFRXF5efnvQPwVyGVBl2cASrwDKQAyGYGYCcj+D8SSyAr+y8nJhcEFoGIgDOOshnOQALqi/woKCgvR1CAUASXdoaoxHAlXBCSCsVkFAlBFXiA2IzZFQLFlQPwGLgC00gEo8AxJAciErXAFSBLJQHwEqGEmutwoIA4AALPDKjAGDC/3AAAAAElFTkSuQmCC>

[image8]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAZCAYAAAAIcL+IAAAAj0lEQVR4XmNgGAVUB3Jycj7y8vL/gfgIENcC8TQVFRV2dEUrQIpgfCD7HZTPCFekqKioDxVkgYkBNdYjawQDqHUogtjEGEECCgoKlciCGAqBVoRiuIUBohAo1w4XkJWV1UG3AgRAYjIyMipArApk98AFYcFgbGzMimwtuiFgdwLxMpgzoPw7QJyNrHAUUAYA1HEv6Gavfg0AAAAASUVORK5CYII=>

[image9]: <data:image/png;base64,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>

[image10]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA8AAAAZCAYAAADuWXTMAAAA10lEQVR4XmNgGF5ARkZGRUFB4ZS8vPx/GNbW1mYDyQHZSUBsiK4HDOTk5BaAFAM1LwQaogoSA9KcIDFRUVEeEI2uBwygtjxGF4cBmCvQxXFLIAGommJ0wauENIIA0CszQU5HESTGVhAAal6JIgAMoFSQRqBEA4oEMYBYW7ECumgGeu+gkpISP4ogUON3YjQDw2QTuhhIsxVIs7Kysiy6HAwA5bvQxeAAKPkLZADQaYJY5EAxwYEujgKAiibD/A+KTyj7Hro6nABkM1CDo6Kioh663CgYsgAA8D5CH963SdYAAAAASUVORK5CYII=>

[image11]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA8AAAAYCAYAAAAlBadpAAAArElEQVR4XmNgGPRAXl7+P7oYUQCocTMlmv+TpVlOTq6NLM1ADZ5AfF9BQWETOZpBGliAdCtJmkGKZWRkhEBsWVlZPxAf6AUtdHVYAVDxCSS2IUgz0Pn+yGqwAqDCZ8h8oCYOqOYOZHEMAFSkCVKIA29HV48CQIrQxUAAZgC6OBxIS0sLA52mgC4OAng1A/Uk4pRkwKEZGA1SSH7CUAA0NBxdHognI6sZBcMbAAAHGEE6SxnD8gAAAABJRU5ErkJggg==>

[image12]: <data:image/png;base64,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>

[image13]: <data:image/png;base64,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>

[image14]: <data:image/png;base64,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>

[image15]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEwAAAAYCAYAAABQiBvKAAAC8UlEQVR4Xu2Xz6tNURzF30uUDIh049wf7o/y4xblJopiyMBA0nsTlFAMDJgZEEVJFFNk8AbmlJhKmSjl/QFvZvx6E/Umz1rP3rdt3X323veeQ+J86gzuWt/v2j/u+Tk1VVHxx2m1Wsuq/S9g7SuqBUHDNxxXVXfZARhsj3q9vjnLsi2QX2ttDDfHdyBzVnsmod1u70XegpM9j2O/1jUajS591b2g+AAmOKO6ixnslKs1m8331DudzkZXHwe7kFQ9FcztDPuxYfvUM9lvVMceHIM+p/oIsYlh8MuoeaE6ifXGMJMfycbkjxvvgnox0LuJvZj3NfUIrowefd8fHV0PCh7GikI+zzLVUkHuDWb3+/116iH3Nj0s/oF6IXi1mI3erZ6LqRlZl9GXVB9iCr6rboG3zdScVo9gYQPVUuG4vkkTZ0Fr1Avh9AXJq8Mf9MSnD6GJRZ9U3cWGm9pb3W63oTWTYPJeqk7MeF9UD4HFHjR9r9RT7HpUr9VqG3z6EJq8plV34RPLDmAPaF+1bhzspYMN2+Pq0G6a/POungL6Fk3vLvUUuw7VSZ6+ijGnVc8DC3znbpz6qaB3qUi/j9Q5oeYt67CWS+qRYEbQDJA6uTyK9vtIzYzVhbxVk49h1Qm8R6pZYoPGKNrvIyWz9fMFfWUwGKxVzxLMoKn3EUuo0UzuseqpmP551YuQuGGsCX4CBjNMwD3VwTQ9bOZhNaCdhfdJdZIyaZzRd1iDG/929UKkZNNH/gfV+SCg53vzd0Hd0eAYeZNA44z1cDx19OB7Sl4egf7MyRweWpeHrcccDqlngf+RNfw2tBr+4HOm74pb6wN1c8E5cXBfAbSL8vtE3lNFQe1n1coC2Xf5Qa26gpqdWNts3u0mD+4FvzJU/wXfhhWh7DyX35lNUvN5v1pQcRKQs4wX4fWqlwE/lmMv2UXAmXU/y7K66l6w0EU0HFF9XJBzXbWyQPZz1cqi1+ttTT27hqTeo/5F+I2sWkVFxV/LDzneHOv20r8CAAAAAElFTkSuQmCC>

[image16]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAAAYCAYAAABKtPtEAAACmUlEQVR4Xu2Xu4tTURDGsw8V8VXFqCS5eUGKIChpBEUEGwvtFGEXBAsrwUbRQlCwFfaPEHYba0H/AkULKwWrNLKVhSzY2KzfZO9c5nyec/fcJHur+4NDzvlmzpyZyX0ktVpFRS1JkrcYu2a8yRlb5LvJ8Q4CnPODtRiwb6fb7Sas/8dgMDipRbHNUq/Xj8f4xWKbyTYFtm3WipAX22G/RITYBsD+XXza7fYztjHwexKKJ3qn07nLekGWQvEdYgqLbQAKv54mf4ZtDHwfhOKF9KJIHNwKQ9YdYgqLbUAR0KT7vnjQXqM591ifBcR54TvDIaawkhuwi2fTEdZnodlsDnxnOMQUFtsA9ZHiSH8uutwi/X7/NOY7GO988XyaAtsvjDVMV9N4L/H5CeuV0L6QnqFJs26JbYAgPp4GyL14lbQJx8O+C6wZVmG/pItkrxlT37zcRB+NRodZz8jbrMzTgNA+aK9Ylyc/awr0n7SWK+B2Ol9vtVrnrF0RP9wK51nPCCVoKasBKOgRawH0FbfEBibN5wbrGaEELWU1APuuseYDPhsxfoL45b4KQwla5mzAxLfP1wCsu6wpuIyPDofDEzL35YL1F7tWxK/X651iPcMXjJmnAarh8r5lpOVQPJ8mpP7fzDzzw3mfO4EfX6F4GRzMR2QDpq8iO9SA+WNZowk3pRGYf0zSK0CGfUrLutFoHNO11dPPh4hxR9eYX8F46nrvAZ+LNg8vJtlltimRDVgI8qpDQR9YnwXku43xl3UHU9gK25QyGyAs6hyJg2ZeZt1BCxuPx4fYppTdACT9HmdNWC8C9p+V/wKsO8jrQQtr5/yFTROa+uX+qlogOOs3a0XY98vSgnjM6ncQ4Jw/rMWAfV9Zq6ioyPgHZ3NDL//XxuMAAAAASUVORK5CYII=>

[image17]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACMAAAAWCAYAAABKbiVHAAABq0lEQVR4Xu2WvUrEQBSFY2UjiD9BzH9CRBBsRVGxEUGwENfKUrCzEAvxAay1sBHBd/AB9Bm0shHWQh9ABBFs9FydwOzJZJOgaxo/GJace+beM8mGXcv6548Iw7DNWhnY88FaB57nTcB0K0a17rHm2KeD+k0QBGesZ7iuO8KaEMfxJPa+sW75vr8ow2FY4ZoKdcW6gBBDqB2xjj4z0E+zQ3E9A7VV1r4GovEJ6wIaj0nddELor6wJ0J+xdtFzp1uYDnBHHBVkk2s6phPieos1plYY0xATJp9JYyqHSZJkUDV84BpjGizXURQd6hpTOQyMl6rhOtcYDpOmab9co8ea7mMqh+EBRcBzrrz7mYYhU6LJ66l7mV6EyflwN5dEcxxnVNeZXw2D+p14bNse0HU8Jlt0hJrVdaZOmKcyY7fAqtZiXadyGEE1fGQdPwuu1NBsgWsZau816zp1w1yoofOatqG0A93LyCGKBqmguYXHusfeHDDGWC3ckWmuFQHvcFGYRkCYF3z0sd4YCPTOWlWw95i1HxF+/+fZZr0M7BnvyWPGl32ZtTLKXpBG+ATGRpmEp5XeJwAAAABJRU5ErkJggg==>

[image18]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAYCAYAAAC8/X7cAAACR0lEQVR4Xu2WPUhbURiGU9Aq6NLWEEzuzQ/JFrBgpg6SSTJJJXOnzu3QpWMptNipoTo4ddJRdOtS6Nq5IA6F4hhEujvq+13OKV/efOf2kh8HzQOHm/u+3885J/fcJJebcceoVCrXrI3LSDVLpVKExJ+S7Ea/Wq12OE4D/0u5XH7EuqDqJMPw+6GYOI7rqN3W8UEwgZYr0GXP6X9YF6CfYPxmnfGTi6LoMXuCnrjG5R2yPoQLPGBdaDabD52/zp7ojUYjz7oGu7iNb/aJq3HGvgB9jzUBG7sVWlxCsVhccYVfsqdxMQOFcL+KcaE1C5+HhXyXz7hWtV+v12NcHmhNIzmyiawnWBOzsOJwf4wdeq01C5/XarXmXZ2+9lFjR98zWO8ucl6xnsvn88uu4CV7TGAB/124PAIYn/z9KHUKhcKSGQPxSAw0eMEeM0pjATG/8DYp+nv/GOlzk7HOcIw1KQs0feNiB94GWXKtGN0X1x7qP+cYxqqTeQEq7t9BQ9PFjLmnhvZZcmu12lqWGoIZl2UB8L9JjHtTsJeaK8gPI2uC752lhmDGQTw3DUVak5Dukfc/ax61gA/sWQR7uSJ/WZe/BuKlHXDx9QFlgk0BHp+nab4GG9FG7BXrCTD23UQ3vYaEjlvYRx3LwO8h762hS+7A4BghpDOIO8Sc3rM+AHYEcZWuHCz20sg6iXGYag8pLotnfVL4p4H1iYEzsDHNBlI79CabGGjyFZc51sdFfq1xxt6xPhWwiB9ouMD6qKDes1ub/Iz7yA2yqdCCDmyFDgAAAABJRU5ErkJggg==>

[image19]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABcAAAAYCAYAAAARfGZ1AAABCElEQVR4Xu2UvQ4BURSE9QrlJrL/kYhEg0Sl0AsSFBqlXu8BvIZHEK+g1xGVRO8JNMxJzm42g3UXlfiSm93MzJn9uZvN5f5kIQiCsud5O6yrrj1WnXOZ8H2/LWWu67bYiy7EujFavGBdsG27JL5lWXn2UnEcp6jFXfaSvHX3pkOmuZgwDAs6dGCPyVyOTVzrUIc9JnO56QD2YyU5HCdJHVoNe9ZLajGm5ZzD+TzSPiqHf9Lc5oGXWn42KJfiC+tCarmgw8cHeiAe3nODvYiX5RheSgj/lGak4Ssai4bjLJllNNNn/Q5cJMQa4U6q7D1Dn3rA+lfQ8iHrH4HCCp5yquVbOefMnx/iBuaIX682QzQKAAAAAElFTkSuQmCC>

[image20]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABcAAAAYCAYAAAARfGZ1AAABMUlEQVR4XmNgGAWkAEVFRXV5efmrQPwfiq8BsRG6OpKAgoKCA8gwOTk5G3Q5mEXo4kQDqMHt6OIgICMjowKSFxcX50aXwwtkZWWloAb7osshA7JcT6wmYtXBgZKSEj9U0w10OXRAsuHASNwE1eSNLocOSDacWA3A+NgAUgekY2Fi0Eh+CBTLQ1YLB8Qajq4OyA4CJV0QG2j4TiC/G64YBtA1YQMg10HVHUYSQ7fsv4qKCjuMDxN8Q4ThIIN+oYndBOJiZDVAihFJCUICiO9hEVcEyQG9bYwuhwyAwZMJVLcUXRwMgJoXgAwBlilmMDGghgiQGJAuQFaLDRDyORgALVEC4hBgjtVBl8MFgAZPBtFAR3AYGxuzosuTDUCpBMYGGp6AJEUZgMYTCkZXMwqGEQAAN4plBarQFAIAAAAASUVORK5CYII=>

[image21]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFwAAAAeCAYAAAChf3k/AAADZUlEQVR4Xu1ZO4gUQRDdkwM/CCq4wg2727N7K4omBioGggf+UFHUQOEUM0FEDzERDDQR1ERBMDDWSMFDQdDIQDA6TsFEQQTxMDAwMBFMzvfWKmhr+ub2A7OznwdNV72q6emq7umZrS0U+hxxHK9Gm7C8hXPuoeXaQbFYXIn7PbD8wACJvIE2b3kfsJ+ynAK2MSTwNseoVConrD0E+ltuoLBIwkdg/2VJPhmh60JcCPB7YrmBQVqSYLuDnXsxwM+Xy+UoxMN/j+Ut0u6Zd3AHfsWOe4Z+mgQCviuB70b/gXKpVFoPfRPkFzZY6rj+HPpPIk/4Ns9VuS9oxy1P0B/tqeUtZH5rLJ97cOJRFK2ljACuoRtR3k8WZezIbSJPIqmxb0O3xOgJOY1TSCJPW96CfpjCFsvnHppYbQj2ivII6JLvpzL4XWj7QzbRZ3URrQ3jH7acol6vF31btVrdjrbB91HAb8alvIwT4PnlB2rtWWGhe8u8zvu6ykjaTugHQzbR33pPw3+28fHxdZZTgP/DxaRcq9Uq7FMS3tRZn4AE9t7yWYH3R5AbPf2Q8ghoyvdTmWc0d2rIZnXK2LlLjf2NPX8lD5d9jkhLeEGOv5YgNwq+QLIAAnIyhwNoM+TkZUnuO9RR6Gepo7/JuSLhj9F/RJukv/jO8kwV+YKOD/kRrjujusc3jiz0VyljR6+yPsQiCW8N3CltXdhj6CRGfhlZjsCYxyy3KHDR604m0ytwHfysx6bcEeBOWi4BfMcuZ3KxYpupy6PHx+qo9e1HINYflmsHOGL24YW81fIJSII/q45EP29md8NnThenmYYFfWnHGDjw25bJ8Dno05bLEnaher2FgnsX4LqW8L4FkjrGxOKDv2x4Jvybz/Ui4rzVw92/79vETpaEN75jMcAta1e4nJ/hLof1cFbj7PndqMBRxk1eYYBlvr3XYOMzyL4eDuM9JPa6yD/R7nPgKIpWoP9t/XsNaUlyw3p4AsN6eJbgxIf18AyhidXG3wzKx12sh8NvrxTW5lgXt76u1Xp4XrBQ8LIAXauH00fKuqMhf3LNnPW5Ayce57gejoU74gL/F8g9Wq+Hdxt5r4fTZjliIX6IQvvJcVIO4YIHbK3XwwcFro2f9U4+P7X5triZevigw2VdDx8iG/wFLBruCVfTpWAAAAAASUVORK5CYII=>

[image22]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABcAAAAYCAYAAAARfGZ1AAABSElEQVR4Xu2Uv0rDUBTGK3Sr4BQCkv8RpKWTopOIuzjVQSj1GfoMXbq1Q4dCJx9BfAXfQFCcCm4OPoGLfkfOjdePi9xEcOoPDrn5zne+9CZNWq0NdcjzfD9N00fUh9YT6oB9tciy7EzCkiQ54Z65EOveaPCUdSGKoj3ph2HY4d6vxHG8q8EX3LNp9Ot9h3x9FUVR7OjQM/eY2uF4iHc6dM49pna47wCex634cBxZWg/aK2pieyt8w9mHd+EU5wNZ4yLXqOW3W+EhF+i/qO/eaLidD9Zc25kB8c3ZsNDgd9YNsgPUgvUvdHjt0HPpYcuH3DPo7Ir1CgzfiAn38dho2PaVaDiOba8L+IbImLP+AxgK1CXe2D73GHiOcGibc91B17I0R8OqZyXrsixj29MYhM3kIxcEwTbWa/k7suevbEmofP+5seH/+QRzDWUU8inOewAAAABJRU5ErkJggg==>

[image23]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABcAAAAYCAYAAAARfGZ1AAABFklEQVR4Xu2UvYrCUBCFxdbCMiD5R7CxUrCy2H6RbSxsLK3X0jfwNXwEtdbKRuxdrITtfQKb9UyYK/Fgws1qJX4wueGcmZN7E7RUelOEKIoaQRDsUX9aP6gW9xUiDMMPCfN9v8ueeRDr1mjwlHXBdd26+I7jVNjLxfO8mgb32Evzr93bDtn2XYnjuKpDB/aYwuH4iEsd+mSPKRxuO4DvMZc+rMM73jdrCbbheX1Zeu6QAf6v9m3Yw2vdQd+yngDjZBEuwWfWQVkumeGCDh/v6JF4eKdt9gR4a12zwzE8kxD8p3SMhuMORMM6Tvca4K1S99nhBjwkRvXxi22yx+hpbwobWXDfw0gwa08BJx3prieoL/bfvAgXlM1gijAS6IwAAAAASUVORK5CYII=>

[image24]: <data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAYCAYAAADDLGwtAAAApklEQVR4XmNgGHxAVlZWSl5e/j8Mo8tjAKjCC+jiGACqMAhdHAUoKCg4EGvtfgyFMjIynCBBOTk5bagisCeApgagKIRK3IHxgQo2YZgGNKUcXRDIX48uBjPtPBYxhEIgRxIkoKysLIukDqbwMbKAJ4YVEHGQwigQG+jeDhDNiK4QyL8MEwO6fydQIQdMYhJQoB7KfgfEU0EKpaSkuID0dyQzRgGFAABbmjhuxRY4PgAAAABJRU5ErkJggg==>

[image25]: <data:image/png;base64,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>