CREATE TABLE if not exists subject.subjects (
    subject_id VARCHAR(50) PRIMARY KEY,
    code VARCHAR(20) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    total_hours INT,
    credits INT
);

-- Subject prerequisites (self-referencing many-to-many)
CREATE TABLE if not exists subject.subject_prerequisites (
    subject_id VARCHAR(50),
    prerequisite_id VARCHAR(50),
    PRIMARY KEY (subject_id, prerequisite_id),
    FOREIGN KEY (subject_id) REFERENCES subject.subjects(subject_id),
    FOREIGN KEY (prerequisite_id) REFERENCES subject.subjects(subject_id)
);


CREATE TABLE if not exists subject.topics (
    topic_id VARCHAR(50) PRIMARY KEY,
    subject_id VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    theory_hours INT,
    FOREIGN KEY (subject_id) REFERENCES subject.subjects(subject_id)
);

-- Topic reference materials (one-to-many list)
CREATE TABLE if not exists  subject.topic_references (
    reference_id SERIAL PRIMARY KEY,
    topic_id VARCHAR(50),
    reference_text TEXT NOT NULL,
    FOREIGN KEY (topic_id) REFERENCES subject.topics(topic_id)
);

