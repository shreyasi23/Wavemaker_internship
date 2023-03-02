

describe('template spec', () => {
  it('passes', () => {
    // Test case: Login
    cy.visit('https://www.amazon.in/');
    cy.get('#nav-link-accountList').click();
    cy.get('#ap_email').click().type('9403575392');
    cy.get('#continue').click();
    cy.get('#ap_password').click().type('Shreyasi#823');
    cy.get('#auth-signin-button').click();
  })
})