describe('template spec', () => {
  it('passes', () => {
    cy.visit('https://www.amazon.in/gp/yourstore/home?path=%2Fgp%2Fyourstore%2Fhome&signIn=1&useRedirectOnSuccess=1&action=sign-out&ref_=nav_AccountFlyout_signout');
    cy.get('#twotabsearchtextbox').click();
    cy.get('#twotabsearchtextbox').type('boat bassheads 105 wired earphones');
    cy.get('#nav-search-submit-button').click();
  })
})