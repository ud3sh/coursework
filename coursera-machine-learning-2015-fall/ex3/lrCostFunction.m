function [J, grad] = lrCostFunction(theta, X, y, lambda)
%LRCOSTFUNCTION Compute cost and gradient for logistic regression with 
%regularization
%   J = LRCOSTFUNCTION(theta, X, y, lambda) computes the cost of using
%   theta as the parameter for regularized logistic regression and the
%   gradient of the cost w.r.t. to the parameters. 

m = length(y); % number of training examples

% ====================== YOUR CODE HERE ======================

n = size(X)(2);
J = 1/m  * sum( -y' * log(sigmoid(X * theta)) - (1-y)' * log(1 - sigmoid(X * theta))) + (lambda/(2 * m)) * sum(theta(2 : n) .^ 2);
grad = 1/m * X' * (sigmoid(X * theta) - y) + lambda/m * [0; theta(2 : n)];

% =============================================================

grad = grad(:);

end
