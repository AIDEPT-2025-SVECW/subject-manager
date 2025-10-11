package com.svecw.dept.manager.subject.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubjectDataProvider {

        private static Map<String, Subject> data;

        static {
                data = new HashMap<>();
                for (Subject subject : getSubjects()) {
                        data.put(subject.getSubjectId(), subject);
                }
        }

        public static Map<String, Subject> getData() {
                return data;
        }

        private static List<Subject> getSubjects() {
                return null;
        }
}
// return Arrays.asList(
// new Subject(
// "MATH101",
// "MATH101",
// "Engineering Mathematics I",
// "Calculus, limits, continuity, differentiation, integration, and basic
// differential equations.",
// 60,

// 4,
// Arrays.asList(
// new Topic(
// "MATH101-T1",
// "Single Variable Calculus",
// "Limits, continuity, differentiation rules, applications of derivatives",
// 18,

// Arrays.asList("Thomas' Calculus",
// "MIT OCW Single Variable Calculus"),"MATH101"),
// new Topic(
// "MATH101-T2",
// "Integration Techniques",
// "Definite/indefinite integrals, substitution, parts, partial fractions",
// 18,

// Arrays.asList("Thomas' Calculus",
// "Paul's Online Math Notes")),
// new Topic(
// "MATH101-T3",
// "First-Order Differential Equations",
// "Separable, linear, exact equations and applications",
// 12,

// Arrays.asList("Elementary Differential Equations by Boyce & DiPrima")))),
// new Subject(
// "MATH201",
// "MATH201",
// "Engineering Mathematics II",
// "Linear algebra, multivariable calculus, and ordinary differential
// equations.",
// 60,

// 4,
// Arrays.asList(
// new Topic(
// "MATH201-T1",
// "Linear Algebra",
// "Matrices, vector spaces, eigenvalues, eigenvectors",
// 22,
// Arrays.asList("Linear Algebra and Its Applications by Gilbert Strang")),
// new Topic(
// "MATH201-T2",
// "Multivariable Calculus",
// "Partial derivatives, multiple integrals, vector calculus",
// 20,
// Arrays.asList("Vector Calculus by Jerrold E. Marsden")),
// new Topic(
// "MATH201-T3",
// "Second-Order ODEs",
// "Homogeneous/inhomogeneous equations, constant coefficients",
// 18,
// Arrays.asList("Differential Equations by Zill")))),
// new Subject(
// "STAT101",
// "STAT101",
// "Probability and Statistics",
// "Descriptive statistics, probability, distributions, estimation, hypothesis
// testing.",
// 45,

// 3,
// Arrays.asList(
// new Topic(
// "STAT101-T1",
// "Probability Basics",
// "Sample spaces, conditional probability, Bayes’ theorem",
// 14,
// Arrays.asList("A First Course in Probability by Sheldon Ross")),
// new Topic(
// "STAT101-T2",
// "Distributions",
// "Binomial, Poisson, Normal, Exponential distributions",
// 16,
// Arrays.asList("Probability and Statistics for Engineers by Walpole")),
// new Topic(
// "STAT101-T3",
// "Inference",
// "Point estimation, confidence intervals, hypothesis testing",
// 15,
// Arrays.asList("Introduction to Statistical Learning")))));
// }
// }
