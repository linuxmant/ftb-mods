package com.example.performanceevaluations

import org.joda.time.DateTime
import org.joda.time.LocalDate

class Person {

    transient springSecurityService

    // Automatic timestamping
    DateTime dateCreated
    DateTime lastUpdated

    // Name
    String displayName
    String firstName
    String lastName
    String middleName

    // Contact
    String emailAddress

    // Departmental
    String employeeID

    // Security
    String username
    String password
    boolean enabled
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static belongsTo = [
            supervisor:Person,
            employeeType:EmployeeType,
            division:Division
    ]

    static hasMany = [
            evaluations:Evaluation,
            performanceReviews:PerformanceReview,
            reports:Person,
            titles:Title,
            evaluationRequests:EvaluationRequest
    ]

    static constraints = {
        username blank: false, unique: true, maxSize: 50
        displayName nullable: true, maxSize: 300
        lastName blank: false, maxSize: 100
        firstName nullable: true, maxSize: 100
        middleName nullable: true, maxSize: 100
        emailAddress email: true, blank: false, maxSize: 500, unique: true
        supervisor nullable: true
        employeeID blank: false, maxSize: 50, unique: true
        password blank: false, maxSize: 1024
    }

    static mapping = {
        // Don't cascade deletes. Throw an error instead.
        reports cascade: 'save-update'

        lastName index: 'person_lastName_idx,person_fullName_idx'
        firstName index: 'person_fullName_idx'
        middleName index: 'person_fullName_idx'
        displayName index:  'person_displayName_idx'
        username index: 'person_userName_idx'

        titles sort: 'startDate', order: 'desc'

        //password column: '`password`'

        sort lastName: "asc"
    }

    static mappedBy = [
            performanceReviews: 'employee'
    ]

    boolean isSupervisorOf(Person person) {
        for (report in reports) {
            if (report == person) {
                // We supervise this person
                return true
            }
        }

        // We don't directly supervise this person
        false
    }

    boolean isTransitiveSupervisorOf(Person person) {
        for (report in reports) {
            if (report.isHigherUpOf(person)) {
                // Our report is a higher up of this person
                return true
            }
        }

        // Our reports don't supervise this person
        false
    }

    boolean isHigherUpOf(Person person) {
        isSupervisorOf(person) || isTransitiveSupervisorOf(person)
    }

    boolean hasReports() {
        Person.countBySupervisor(this) > 0
    }

    PerformanceReview getLastPerformanceReview() {
        PerformanceReview.findByEmployee(this, [sort: "dateCreated", order: "desc"])
    }

    Title getCurrentTitle() {
        Title.findByPerson(this, [sort: "startDate", order: "desc"])
    }

    LocalDate getCurrentStartDate() {
        currentTitle?.startDate
    }

    String toString() {displayName}

    // *** DisplayName methods ***
    // TODO: Unit test the get/set display name bits
    String getDisplayName() {
        // If a display name isn't set, build one from the first, last, and middle names
        displayName ?: defaultDisplayName()
    }

    void setDisplayName(String newDisplayName) {
        // If a new display name is set that matches the default, store null instead
        if (newDisplayName == defaultDisplayName()) {
            displayName = null
        } else {
            displayName = newDisplayName
        }
    }

    String defaultDisplayName() {
        def name = lastName
        if (firstName || middleName) {
            name += ","
            name += firstName ? " $firstName" : ""
            name += middleName ? " $middleName" : ""
        }
        name
    }

    // *** Security-oriented methods ***
    Set<Role> getRoles() {
        PersonRole.findAllByPerson(this).collect { PersonRole pr -> pr.role } as Set
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }
}