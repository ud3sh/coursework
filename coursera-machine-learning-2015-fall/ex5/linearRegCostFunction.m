function [J, grad] = linearRegCostFunction(X, y, theta, lambda)
%LINEARREGCOSTFUNCTION Compute cost and gradient for regularized linear 
%regression with multiple variables
%   [J, grad] = LINEARREGCOSTFUNCTION(X, y, theta, lambda) computes the 
%   cost of using theta as the parameter for linear regression to fit the 
%   data points in X and y. Returns the cost in J and the gradient in grad

% Initialize some useful values
m = length(y); % number of training examples

% ====================== YOUR CODE HERE ======================

n=size(X, 2);

J = 1/(2*m) * sum((X * theta - y).^2) + lambda/(2*m) * sumsq(theta(2:end,:));
for j =1:n 
    grad(j) = 1/m * sum((X * theta - y) .* X(:,j)) + lambda/m * ( [0; theta(2:end,:)](j) );
end
% ============================================================

grad = grad(:);

end
